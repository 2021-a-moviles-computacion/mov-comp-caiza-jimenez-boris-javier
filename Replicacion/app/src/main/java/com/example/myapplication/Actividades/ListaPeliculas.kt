package com.example.myapplication.Actividades

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Adaptador.AdaptadorPeliculasFinal
import com.example.myapplication.Adaptador.AdaptadorTrailer
import com.example.myapplication.Datos.Pelicula
import com.example.myapplication.Datos.Trailer
import com.example.myapplication.R

class ListaPeliculas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_peliculas)

        var recyclerTrailer = findViewById<RecyclerView>(R.id.alprecycler)

        recyclerTrailer.layoutManager = LinearLayoutManager(this)
         recyclerTrailer.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        recyclerTrailer.adapter = AdaptadorPeliculasFinal(generarDatosPeliculas(),this)


    }

    private fun generarTrailer():ArrayList<Trailer>{
        var lista = ArrayList<Trailer>()
        lista.add(
            Trailer(
                R.drawable.news111,"The Suicide Squad cast hails the 'genius' of James Gunn, great movie",
                "The team behind the acclaimed DC movie breaks down some of the movie's most epic scenes and talks about the wildest version of Hareky Quinn we've secretly seen yet, a great movie already in theaters, full of emotions")
        )
        lista.add(Trailer(R.drawable.news222,"Comic-Con 2021: The biggest Movie, TV Show, and Streaming Trailers ","The biggest movie, Tv show, and streaming trailers"))
        return  lista
    }

    private fun generarDatosPeliculas(): ArrayList<Pelicula> {
        val lista = ArrayList<Pelicula>()
        lista.add(
            Pelicula(
                R.drawable.interestelar_2,
                "Interestelar",
                "Christopher Nolan",
                "Ciencia ficción",
                4.3,
                169,
                "2014",
                "40%",
                R.drawable.fresco,
                "PG-13",
                "95%",
                R.drawable.sobresaliente
            )
        )
        lista.add(
            Pelicula(
                R.drawable.forma_agua_2,
                "La forma del agua",
                "Guillermo del Toro",
                "Cine fantástico",
                3.65,
                123,
                "2017",
                "89%",
                R.drawable.sobresaliente,
                "PG-13",
                "98%",
                R.drawable.sobresaliente
            )
        )
        lista.add(
            Pelicula(
                R.drawable.extraordinario_2,
                "Extraordinario",
                "Stephen Chbosky",
                "Drama",
                4.0,
                113,
                "2017",
                "89%",
                R.drawable.sobresaliente,
                "PG-13",
                "95%",
                R.drawable.sobresaliente
            )
        )
        lista.add(
            Pelicula(
                R.drawable.la_llegada_2,
                "La llegada",
                "Denis Villeneuve",
                "Ciencia ficción",
                3.95,
                116,
                "2016",
                "39%",
                R.drawable.podrido,
                "PG-13",
                "95%",
                R.drawable.sobresaliente
            )
        )
        lista.add(
            Pelicula(
                R.drawable.ex_maquina_2,
                "Ex-Máquina",
                "Alex Garland",
                "Ciencia ficción",
                3.85,
                108,
                "2015",
                "75%",
                R.drawable.fresco,
                "PG-13",
                "70%",
                R.drawable.fresco
            )
        )
        lista.add(
            Pelicula(
                R.drawable.jumajin_2,
                "Jumanji: En la selva",
                "Jake Kasdan",
                "Acción",
                3.5,
                119,
                "2017",
                "22%",
                R.drawable.podrido,
                "PG-13",
                "65%",
                R.drawable.fresco
            )
        )

        return lista
    }
}