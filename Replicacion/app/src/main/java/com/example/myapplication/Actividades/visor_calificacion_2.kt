package com.example.myapplication.Adaptador

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Datos.MovieStreaming
import com.example.myapplication.Datos.Pelicula
import com.example.myapplication.R

class visor_calificacion_2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visor_calificacion2)


        val pelicula = intent.getSerializableExtra("mov") as MovieStreaming

        val titulo = findViewById<TextView>(R.id.avctitulo2)
        titulo.setText(pelicula.nombre)

        val clasificacion = findViewById<TextView>(R.id.acvclasificacion2)
        clasificacion.setText(pelicula.clasificacion+" "+pelicula.fecha+", "+pelicula.genero+", "+pelicula.duracion.toString()+"m")


        val calificacion = findViewById<ImageView>(R.id.avccertificado22)
        calificacion.setImageResource(pelicula.certificado_imagen)

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
        recyclerPelicula.adapter = AdaptadorPeliculas(generarDatosPeliculas(),this)

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