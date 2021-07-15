package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.text.SimpleDateFormat

class Prueba : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prueba)
        BaseDatos.TablaCine= SQLCine(this)
        val a= intent.getParcelableExtra<ECine>("cine")
        val nombre = findViewById<EditText>(R.id.txt_crear_nombre)
        val direccion =  findViewById<EditText>(R.id.txt_crear_director)
        val taquilla =  findViewById<EditText>(R.id.txt_crear_taquilla)
        val cartelera =  findViewById<EditText>(R.id.txt_crear_cartelera)


       // val id_2 = pel!!.id_cine_a
      //  val id:Int = Cine.id_a
        val id_2 = a!!.id_cine




        val botoneditar = findViewById<Button>(R.id.btn_Crear_pelicula_3)
        botoneditar.setOnClickListener {
            if (nombre.text.isNotBlank() && direccion.text.isNotBlank() && taquilla.text.isNotBlank() &&
                cartelera.text.isNotBlank()
            ) {
                if (BaseDatos.TablaCine != null) {
                    val cine = BaseDatos.TablaCine!!.crearPelicula(
                        nombre.text.toString(),
                        direccion.text.toString(),
                        taquilla.text.toString().toDouble(),
                        cartelera.text.toString().toBoolean(),
                        id_2
                    )
                    if (cine == true) {
                        Toast.makeText(this, "cine actualizado con exito", Toast.LENGTH_SHORT)
                            .show()

                        abrirActividad(Pelicula::class.java)
                    } else {
                        Toast.makeText(this, "error al actualizar cine", Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this, "Llene los Campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
    fun abrirActividad(clase: Class<*>){
        val intentExplicito = Intent(
            this,
            clase
        )
        startActivity(intentExplicito)
    }
}