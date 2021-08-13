package com.example.myapplication.Actividades

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Adaptador.AdaptadorPeliculas
import com.example.myapplication.Datos.Pelicula
import com.example.myapplication.R

class VisorCalificacion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visor_calificacion)


        val pelicula = intent.getSerializableExtra("pel") as Pelicula

        val titulo = findViewById<TextView>(R.id.avctitulo2)
        titulo.setText(pelicula.titulo)

        val clasificacion = findViewById<TextView>(R.id.acvclasificacion2)
        clasificacion.setText(pelicula.clasificacion+" "+pelicula.fecha+", "+pelicula.genero+", "+pelicula.duracion.toString()+"m")


        val calificacion = findViewById<ImageView>(R.id.avccertificado22)
        calificacion.setImageResource(pelicula.imagen_certificado)

        val calificacion_texto = findViewById<TextView>(R.id.avccalcertificado22)
        calificacion_texto.setText(pelicula.certificado)


        val calificacion2 = findViewById<ImageView>(R.id.certificado222)
        calificacion2.setImageResource(pelicula.imagen_certificado_cliente)

        val calificacion_texto2 = findViewById<TextView>(R.id.avccalcertificado222)
        calificacion_texto2.setText(pelicula.certificado_cliente)

        var recyclerPelicula = findViewById<RecyclerView>(R.id.avcpeliculas2)

        recyclerPelicula.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.HORIZONTAL, false)
        // recycler.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        recyclerPelicula.adapter = AdaptadorPeliculas(generarDatosPeliculasDC(),this)

    }

    private fun generarDatosPeliculasDC(): ArrayList<Pelicula> {
        val lista = ArrayList<Pelicula>()
        lista.add(
            Pelicula(
                R.drawable.batman,
                "The Dark Knigth",
                "Christopher Nolan",
                "Ciencia ficción",
                4.3,
                169,
                "2014",
                "99%",
                R.drawable.sobresaliente,
                "PG-13",
                "95%",
                R.drawable.sobresaliente

            )
        )

        lista.add(
            Pelicula(
                R.drawable.suicesquad,
                "The Suicede Squad",
                "Christopher Nolan",
                "Ciencia ficción",
                4.3,
                169,
                "2014",
                "92%",
                R.drawable.sobresaliente,
                "PG-13",
                "55%",
                R.drawable.podrido
            )
        )

        lista.add(
            Pelicula(
                R.drawable.linternaverde,
                "Green Latern",
                "Christopher Nolan",
                "Ciencia ficción",
                4.3,
                169,
                "2014",
                "82%",
                R.drawable.sobresaliente,
                "PG-13",
                "10%",
                R.drawable.podrido
            )
        )
        return  lista
    }
}