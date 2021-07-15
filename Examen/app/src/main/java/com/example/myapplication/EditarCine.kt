package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.text.SimpleDateFormat

class EditarCine : AppCompatActivity() {
    var CODIGO_RESPUESTA_INTENT_EXPLICITO = 403

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_cine)
        BaseDatos.Base= Tablas(this)
        val cine_pelicula = intent.getParcelableExtra<ECine>("cine")
        Log.i("bdd","Editar ${cine_pelicula}")
        val nombre = findViewById<EditText>(R.id.txt_nombre_editar)
        val direccion =  findViewById<EditText>(R.id.txt_descripcion_editar)
        val salas =  findViewById<EditText>(R.id.txt_salas_Editar)
        val estrellas =  findViewById<EditText>(R.id.txt_estrellas_editar)
        val fecha =  findViewById<EditText>(R.id.txt_fecha_editar)


        val id:Int = cine_pelicula!!.id_cine


       nombre.setText(cine_pelicula?.nombre)
        direccion.setText(cine_pelicula?.dirección)
       salas.setText(cine_pelicula?.salas.toString())
        estrellas.setText(cine_pelicula?.estrellas.toString())
        fecha.setText(SimpleDateFormat("dd/MM/yyyy").format(cine_pelicula?.fecha_estrenos))


        val botoneditar = findViewById<Button>(R.id.btn_editar)
        botoneditar.setOnClickListener {
            if (nombre.text.isNotBlank() && direccion.text.isNotBlank() && salas.text.isNotBlank() &&
                estrellas.text.isNotBlank() && fecha.text.isNotBlank()
            ) {
                if(
                     validar_sala(salas.text.toString()) == true && validar_fecha(fecha.text.toString()) == true &&
                    validar_estrella(estrellas.text.toString()) == true
                ) {
                    if (BaseDatos.Base != null) {
                        val cine = BaseDatos.Base!!.editarCine(
                            nombre.text.toString(),
                            direccion.text.toString(),
                            salas.text.toString().toInt(),
                            estrellas.text.toString().toDouble(),
                            SimpleDateFormat("dd/MM/yyyy").parse(fecha.text.toString()),
                            id
                        )
                        if (cine == true) {
                            Toast.makeText(this, "cine actualizado con exito", Toast.LENGTH_SHORT)
                                .show()

                            abrirActividadConParametros(Pelicula::class.java, cine_pelicula!!)
                        } else {
                            Toast.makeText(this, "error al actualizar cine", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                }else{
                    Toast.makeText(this, "Llene lso campos correctamente", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Llene los Campos", Toast.LENGTH_SHORT).show()
            }
        }

        }

    fun validar_nombre(nombre:String): Boolean{
        val validar = Regex("^[a-zA-Z]+\\ [a-zA-Z]*$")

        return validar.matches(nombre)

    }



    fun validar_direccion(direccion:String):Boolean{
        val validar = Regex("^[a-zA-Z]+\\ [a-zA-Z]*$")
        return validar.matches(direccion)
    }

    fun validar_sala(sala: String):Boolean{
        val validar = Regex("^[0-9]{1,2}\$")
        return validar.matches(sala)
    }

    fun validar_estrella(estrella: String):Boolean{
        val validar = Regex("[0-9]+\\.[0-9]+")
        return validar.matches(estrella)
    }

    fun validar_fecha(fecha:String):Boolean{
        val validar = Regex("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])\\/(19|20)\\d\\d")
        return validar.matches(fecha)
    }


    fun abrirActividad(clase: Class<*>){
        val intentExplicito = Intent(
            this,
            clase
        )
        startActivity(intentExplicito) }


    fun abrirActividadConParametros(clase: Class<*>, cine: ECine, ){
        val intentExplicito = Intent(
            this,
            clase
        )
        intentExplicito.putExtra("cine",cine)
        startActivityForResult(intentExplicito,CODIGO_RESPUESTA_INTENT_EXPLICITO)

    }
}