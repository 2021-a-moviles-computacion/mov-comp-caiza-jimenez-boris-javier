package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class CrearPelicula : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prueba)
        BaseDatos.Base = Tablas(this)
        val a = intent.getParcelableExtra<ECine>("cine")
        val nombre = findViewById<EditText>(R.id.txt_crear_nombre)
        val direccion = findViewById<EditText>(R.id.txt_crear_director)
        val taquilla = findViewById<EditText>(R.id.txt_crear_taquilla)
        val cartelera = findViewById<EditText>(R.id.txt_crear_cartelera)



          val id:Int = Cine.id_a



        val botoneditar = findViewById<Button>(R.id.btn_Crear_pelicula_3)
        botoneditar.setOnClickListener {
            if (nombre.text.isNotBlank() && direccion.text.isNotBlank() && taquilla.text.isNotBlank() &&
                cartelera.text.isNotBlank()
            ) {
                if (
                        validar_taquilla(taquilla.text.toString()) == true &&
                        validar_cartelera(cartelera.text.toString()) == true) {
                    if (BaseDatos.Base != null) {
                        val cine = BaseDatos.Base!!.crearPelicula(
                            nombre.text.toString(),
                            direccion.text.toString(),
                            taquilla.text.toString().toDouble(),
                            cartelera.text.toString().toBoolean(),
                            id
                        )
                        if (cine == true) {
                            Toast.makeText(this, "cine actualizado con exito", Toast.LENGTH_SHORT)
                                .show()

                            abrirActividad(Pelicula::class.java)
                        } else {
                            Toast.makeText(this, "error al actualizar cine", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                }else{
                    Toast.makeText(this, "Llene correctamente los campos", Toast.LENGTH_SHORT).show()
                }
                } else {
                    Toast.makeText(this, "Llene los Campos", Toast.LENGTH_SHORT).show()
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
}

