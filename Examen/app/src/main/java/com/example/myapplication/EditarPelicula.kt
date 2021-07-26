package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class EditarPelicula : AppCompatActivity() {

    var CODIGO_RESPUESTA_INTENT_EXPLICITO = 404
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_pelicula)
        BaseDatos.Base = Tablas(this)
        val pel = intent.getParcelableExtra<EPelicula>("pelicula")
        //val cine = intent.getParcelableExtra<ECine>("cine")
        val id = pel!!.id_pelicula
        val nombre = findViewById<EditText>(R.id.txt_nombre_editar_pelicula)
        val director = findViewById<EditText>(R.id.txt_director_editar_pelicula)
        val taquilla = findViewById<EditText>(R.id.txt_editar_taquilla_pelicula)
        val cartelera = findViewById<EditText>(R.id.txt_editar_cartelera)
        val botonEditar = findViewById<Button>(R.id.btn_editar_pelicula)
        val aux_taquilla = pel!!.taquilla.toString()
        val aux_cartelera = pel!!.cartelera.toString()
        nombre.setText(pel?.nombre)
        director.setText(pel?.director)
        taquilla.setText(aux_taquilla)
        cartelera.setText(aux_cartelera)

        botonEditar.setOnClickListener {
            if (BaseDatos.Base != null) {

                if (nombre.text.toString().isNotBlank() &&
                    director.text.toString().isNotBlank() &&
                    taquilla.text.toString().isNotBlank() &&
                    cartelera.text.toString().isNotBlank()
                ) {
                    if (
                        validar_taquilla(taquilla.text.toString()) == true &&
                        validar_cartelera(cartelera.text.toString()) == true) {

                        val pelicula = BaseDatos.Base!!.editarPelicula(
                            nombre.text.toString(),
                            director.text.toString(),
                            taquilla.text.toString().toDouble(),
                            cartelera.text.toString().toBoolean(), id
                        )

                        if (pelicula == true) {
                            Toast.makeText(this, "Pelicula Editada con exito", Toast.LENGTH_SHORT)
                                .show()
                            abrirActividad(Pelicula::class.java)


                        } else {
                            Toast.makeText(
                                this,
                                "No se pudo editar la pelicula",
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        }
                    }else{
                        Toast.makeText(
                            this,
                            "Llene los campos correctamente",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }
                } else {
                    Toast.makeText(this, "Llene los Campos", Toast.LENGTH_SHORT).show()
                }
            }


        }


    }

    fun validar_nombre(nombre: String): Boolean {
        val validar = Regex("^[a-zA-Z0-9]+\\ [a-zA-Z0-9]*$")

        return validar.matches(nombre)

    }


    fun validar_direccion(direccion: String): Boolean {
        val validar = Regex("^[a-zA-Z]+$")
        return validar.matches(direccion)
    }


    fun validar_taquilla(estrella: String): Boolean {
        val validar = Regex("^[0-9]+\\.[0-9]+$")
        return validar.matches(estrella)
    }

    fun validar_cartelera(cartelera: String): Boolean {
        if (cartelera == "true") {
            return true
        }
        if (cartelera == "false") {
            return true
        } else {
            return false
        }
    }

    fun abrirActividad(clase: Class<*>) {
        val intentExplicito = Intent(
            this,
            clase
        )
        startActivity(intentExplicito)

    }

    fun abrirActividadConParametros(clase: Class<*>, cine: ECine, ){
        val intentExplicito = Intent(
            this,
            clase
        )
        intentExplicito.putExtra("cine",cine)
        startActivityForResult(intentExplicito,CODIGO_RESPUESTA_INTENT_EXPLICITO)

    }
}
