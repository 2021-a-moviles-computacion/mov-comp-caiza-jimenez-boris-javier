package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.SearchView.OnQueryTextListener

class MainActivity : AppCompatActivity(), OnQueryTextListener {
    var svSear: SearchView ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //////////////Peliculas
        var recyclerPelicula = findViewById<RecyclerView>(R.id.amRvPeliculas)

        recyclerPelicula.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false)
       // recycler.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        recyclerPelicula.adapter = AdaptadorPeliculas(generarDatosPeliculas(),this)

        //////////////Banner
       var recyclerBanner = findViewById<RecyclerView>(R.id.amRvBanner)

        recyclerBanner.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false)
        // recycler.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        recyclerBanner.adapter = AdaptadorBanner(generarBanner(),this)


        ////////////////////////////

       var recyclerStraming = findViewById<RecyclerView>(R.id.prueba)

        recyclerStraming.layoutManager = LinearLayoutManager(this)

       // recyclerStraming.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false)
        recyclerStraming.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        recyclerStraming.adapter = AdaptadorStreaming(generarStreaming(),this, generarStreaming())




/////////////////////




    }



   private fun generarStreaming():ArrayList<MovieStreaming>{
        var lista = ArrayList<MovieStreaming>()
        lista.add(MovieStreaming("Ex maquina","89%",R.drawable.sobresaliente))
        lista.add(MovieStreaming("Ex maquina","89%",R.drawable.sobresaliente))
        lista.add(MovieStreaming("Ex maquina","89%",R.drawable.podrido))
        lista.add(MovieStreaming("Ex maquina","89%",R.drawable.podrido))
        lista.add(MovieStreaming("Ex maquina","89%",R.drawable.sobresaliente))
        return  lista
    }

    private fun generarBanner():ArrayList<Banner>{
        var lista = ArrayList<Banner>()
        lista.add(Banner(R.drawable.banner1))
        lista.add(Banner(R.drawable.banner2))
        lista.add(Banner(R.drawable.banner3))

        return  lista

    }
    private fun generarDatosPeliculas(): ArrayList<Pelicula> {
        val lista = ArrayList<Pelicula>()
        lista.add(
            Pelicula(
                R.drawable.interestelar,
                "Interestelar",
                "Christopher Nolan",
                "Ciencia ficción",
                4.3,
                169,
                "2014",
                "89%",
                R.drawable.sobresaliente
            )
        )
        lista.add(
            Pelicula(
                R.drawable.forma_agua,
                "La forma del agua",
                "Guillermo del Toro",
                "Cine fantástico",
                3.65,
                123,
                "2017",
                "89%",
                R.drawable.sobresaliente
            )
        )
        lista.add(
            Pelicula(
                R.drawable.extraordinario,
                "Extraordinario",
                "Stephen Chbosky",
                "Drama",
                4.0,
                113,
                "2017",
                "89%",
                R.drawable.sobresaliente
            )
        )
        lista.add(
            Pelicula(
                R.drawable.la_llegada,
                "La llegada",
                "Denis Villeneuve",
                "Ciencia ficción",
                3.95,
                116,
                "2016",
                "89%",
                R.drawable.sobresaliente
            )
        )
        lista.add(
            Pelicula(
                R.drawable.ex_maquina,
                "Ex-Máquina",
                "Alex Garland",
                "Ciencia ficción",
                3.85,
                108,
                "2015",
                "89%",
                R.drawable.sobresaliente
            )
        )
        lista.add(
            Pelicula(
                R.drawable.jumanji,
                "Jumanji: En la selva",
                "Jake Kasdan",
                "Acción",
                3.5,
                119,
                "2017",
                "89%",
                R.drawable.sobresaliente
            )
        )

        return lista
    }

    private fun initListener(){
        svSear!!.setOnQueryTextListener(this)
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        val a = AdaptadorStreaming(generarStreaming(), this, generarStreaming())
        a.filter(newText!!)
        return false

    }


}