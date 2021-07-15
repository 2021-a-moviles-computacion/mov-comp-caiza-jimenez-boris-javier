package com.example.myapplication

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

class Tablas(context: Context):SQLiteOpenHelper(context,"examen",null,1) {

    override fun onCreate(db: SQLiteDatabase?) {
        val scriptCrearTablaUsuario=
            """
            CREATE TABLE CINE(
            ID_CINE INTEGER PRIMARY KEY AUTOINCREMENT,
            NOMBRE VARCHAR(10),
            DESCRIPCION VARCHAR(50),
            SALAS INTEGER,
            ESTRELLAS REAL,
            FECHA_ESTRENO date);
  
            """.trimIndent()
        Log.i("bdd", "Creacion tabla usuario")
        db?.execSQL(scriptCrearTablaUsuario)



        val scriptCrearTablaPelicula=
            """
            CREATE TABLE PELICULA(
            ID_PELICULA INTEGER PRIMARY KEY AUTOINCREMENT,
            ID_CINE_A INTEGER,
            NOMBRE_PELICULA VARCHAR(50),
            DIRECTOR VARCHAR(50),
            TANQUILLA REAL,
            CARTELERA INTEGER,
            foreign key(ID_CINE_A) references CINE(ID_CINE)
            );
  
            """.trimIndent()
        Log.i("bdd", "Creacion tabla Pelicula")
        db?.execSQL(scriptCrearTablaPelicula)


    }


    fun crearCine(nombre: String, descripcion: String, salas:Int , estrellas:Double, fecha_estreno:String):Boolean{

        val conexionEscritura= writableDatabase
        val valoresAGuardar= ContentValues()

        valoresAGuardar.put("NOMBRE",nombre)
        valoresAGuardar.put("DESCRIPCION", descripcion)
        valoresAGuardar.put("SALAS", salas)
        valoresAGuardar.put("ESTRELLAS", estrellas)
        valoresAGuardar.put("FECHA_ESTRENO", fecha_estreno)

        val resultadoEscritura: Long= conexionEscritura.insert("CINE", null,valoresAGuardar)
        conexionEscritura.close()
        if(resultadoEscritura.toInt()!=-1){
            return true
        }else{
            return false
        }

    }


    fun consultarCineTodo(): ArrayList<ECine> {
        val formato = SimpleDateFormat("dd/MM/yyyy")
        val scriptConsultarUsuario = "SELECT * FROM CINE"
        val baseDatosLectura = readableDatabase
        val resultaConsultaLectura = baseDatosLectura.rawQuery(scriptConsultarUsuario, null)
        val existeUsuario = resultaConsultaLectura.moveToFirst()
        var arregloUsuario = arrayListOf<ECine>()

        if(existeUsuario){
            do{
                val id = resultaConsultaLectura.getInt(0) //columna con el indice 0 -> en nuestro caso es el identificador
                if(id!=null){
                    arregloUsuario.add(
                        ECine(id,
                            resultaConsultaLectura.getString(1),
                            resultaConsultaLectura.getString(2),
                            resultaConsultaLectura.getInt(3),
                            resultaConsultaLectura.getDouble(4),
                            SimpleDateFormat("dd/MM/yyyy").parse(resultaConsultaLectura.getString(5))
                        ))
                }
            }while(resultaConsultaLectura.moveToNext())
        }

        resultaConsultaLectura.close()
        baseDatosLectura.close()
        return arregloUsuario
    }

    fun editarCine(nombre:String, direccion:String, salas: Int, estrellas: Double, fechaNacimiento: Date, idActualizar:Int): Boolean {
        val formato = SimpleDateFormat("dd/MM/yyyy")
        val conexionEscritura = writableDatabase
        val valorAActualizar = ContentValues()

        valorAActualizar.put("NOMBRE", nombre)
        valorAActualizar.put("DESCRIPCION", direccion)
        valorAActualizar.put("SALAS", salas)
        valorAActualizar.put("ESTRELLAS", estrellas)
        valorAActualizar.put("FECHA_ESTRENO", formato.format(fechaNacimiento))


        val resultadoActualizacion = conexionEscritura.update("CINE", valorAActualizar, "ID_CINE=?",
            arrayOf(idActualizar.toString())
        )
        conexionEscritura.close()

        if(resultadoActualizacion.toInt()!=-1){

            return true
        }else{

            return false
        }

    }

    fun eliminarCine(id: Int):Boolean{
        val conexionEscritura = readableDatabase
        val resultadoEliminacion = conexionEscritura.delete("CINE","ID_CINE=?",
            arrayOf(id.toString()))
        conexionEscritura.close()

        if(resultadoEliminacion.toInt()!=-1){

            return true
        }else{
            return false
        }

    }


    fun cossultarPelicula(id_cine: Int): ArrayList<EPelicula> {
        val scriptConsultaCine = "SELECT * FROM PELICULA WHERE ID_CINE_A = ${id_cine}"
        val baseDatosLectura = readableDatabase
        val resultaConsultaLectura = baseDatosLectura.rawQuery(scriptConsultaCine, null)
        val existePelicula = resultaConsultaLectura.moveToFirst()
        val arregloPelicula = arrayListOf<EPelicula>()
        if(existePelicula){
            do{
                val id = resultaConsultaLectura.getInt(0)
                val nomnbre = resultaConsultaLectura.getString(2)
                val director = resultaConsultaLectura.getString(3)
                val taquilla = resultaConsultaLectura.getDouble(4)
                val cartelera = resultaConsultaLectura.getInt(5)
                val cartelera1 = bolean_entero(cartelera)


                if(id!=null){
                    arregloPelicula.add(
                        EPelicula(id, id_cine, nomnbre, director, taquilla, cartelera1))
                }
            }while(resultaConsultaLectura.moveToNext())
        }

        resultaConsultaLectura.close()
        baseDatosLectura.close()
        return arregloPelicula
    }

    fun editarPelicula(nombre:String, director:String, taquilla:Double, cartelera:Boolean, idActualizar:Int): Boolean {

        val conexionEscritura = writableDatabase
        val valorAActualizar = ContentValues()

        valorAActualizar.put("NOMBRE_PELICULA", nombre)
        valorAActualizar.put("DIRECTOR", director)
        valorAActualizar.put("TANQUILLA", taquilla)
        valorAActualizar.put("CARTELERA", cartelera)



        val resultadoActualizacion = conexionEscritura.update("PELICULA", valorAActualizar, "ID_PELICULA=?",
            arrayOf(idActualizar.toString())
        )
        conexionEscritura.close()

        if(resultadoActualizacion.toInt()!=-1){

            return true
        }else{

            return false
        }

    }

    fun bolean_entero(a:Int):Boolean{
        if(a == 0){
            return false
        }

        if(a ==1){
            return true
        }

        else return false

    }

    fun crearPelicula(nombre: String, director: String, taquilla: Double, cartelera: Boolean, id:Int):Boolean{

        val conexionEscritura= writableDatabase
        val valoresAGuardar= ContentValues()
        valoresAGuardar.put("ID_CINE_A",id)
        valoresAGuardar.put("NOMBRE_PELICULA",nombre)
        valoresAGuardar.put("DIRECTOR",director)
        valoresAGuardar.put("TANQUILLA", taquilla)
        valoresAGuardar.put("CARTELERA", cartelera)


        val resultadoEscritura: Long= conexionEscritura.insert("PELICULA", null,valoresAGuardar)
        conexionEscritura.close()
        if(resultadoEscritura.toInt()!=-1){
            return true
        }else{
            return false
        }
    }


    fun eliminarPelicula(id: Int):Boolean{
        val conexionEscritura = readableDatabase
        val resultadoEliminacion = conexionEscritura.delete("PELICULA","ID_PELICULA=?",
            arrayOf(id.toString()))
        conexionEscritura.close()

        if(resultadoEliminacion.toInt()!=-1){

            return true
        }else{
            return false
        }

    }


    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

}