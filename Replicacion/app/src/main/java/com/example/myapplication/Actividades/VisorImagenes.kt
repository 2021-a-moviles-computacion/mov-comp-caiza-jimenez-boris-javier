package com.example.myapplication.Actividades

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.myapplication.Datos.Pelicula
import com.example.myapplication.R

class VisorImagenes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visor_imagenes)

        val pelicula = intent.getSerializableExtra("pel") as Pelicula

        val imagen = findViewById<ImageView>(R.id.idvspelicula)
        imagen.setImageResource(pelicula.idImagen)
    }
}