package com.example.myapplication

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class ESqliteHelperUsuario (contexto: Context?): SQLiteOpenHelper(
    contexto,
    "moviles",
    null,
    1
) {
    override fun onCreate(db: SQLiteDatabase?) {
        val scriptCrearTablaUsuario =
            """
                CREATE TABLE USUARIO(
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nombre VARCHAR(50),
                descripcion varchar(50)
                )
            """.trimIndent()
        Log.i("bbd","Creado la tabla de usuario")
        db?.execSQL(scriptCrearTablaUsuario)
    }

    fun creatUsuarioFormulario(nombre: String, descripcion: String):Boolean{
        val conexionEscritura = writableDatabase
        val valoresAGuardar = ContentValues()
        valoresAGuardar.put("nombre",nombre)
        valoresAGuardar.put("descripcion",descripcion)
        val resultadoEscritura: Long = conexionEscritura.insert(
            "USUARIO",
            null,
            valoresAGuardar
        )
        conexionEscritura.close()
        return  if(resultadoEscritura.toInt()  == -1) false else true
    }

    fun consultarUsuarioPorId(id:Int): EUsuarioBDD{
        val scriptConsultarUsuario = "SELECT * FROM USUARIO WHERE ID = ${id}"
        val baseDatosLectura = readableDatabase
        val resultaConsultaLectura = baseDatosLectura.rawQuery(scriptConsultarUsuario, null)
        val existeUsuario = resultaConsultaLectura.moveToFirst()
        val arregloUsuario = arrayListOf<EUsuarioBDD>()
        val usuarioEencontrad = EUsuarioBDD(0,"","")
        if(existeUsuario){
            do{
                val id = resultaConsultaLectura.getInt(0) //columna con el indice 0 -> en nuestro caso es el identificador
                val nombre = resultaConsultaLectura.getString(1)
                val descripcion = resultaConsultaLectura.getString(2)
                if(id!=null){
                    usuarioEencontrad.id = id
                    usuarioEencontrad.nombre = nombre
                    usuarioEencontrad.descripcion = descripcion
                    //arregloUsuario.add(usuarioEncontrado)
                }
            }while(resultaConsultaLectura.moveToNext())

        }

        resultaConsultaLectura.close()
        baseDatosLectura.close()
        return usuarioEencontrad
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {}
}