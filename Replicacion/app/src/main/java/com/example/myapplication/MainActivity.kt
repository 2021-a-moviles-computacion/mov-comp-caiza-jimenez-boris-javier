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
        recyclerStraming.adapter = AdaptadorStreaming(generarStreaming(),this)

        /////////////////////////////

        var recyclerTv = findViewById<RecyclerView>(R.id.ultimo)

        recyclerTv.layoutManager = LinearLayoutManager(this)

        // recyclerStraming.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false)
        recyclerTv.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        recyclerTv.adapter = AdaptadorStreaming(generarMovieTv(),this)

        ///////////////////////////

        var recyclerCine = findViewById<RecyclerView>(R.id.cine)

        recyclerCine.layoutManager = LinearLayoutManager(this)

        // recyclerStraming.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false)
        recyclerCine.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        recyclerCine.adapter = AdaptadorStreaming(generarTheaters(),this)

        //////////////////////+

        var recyclerFinal = findViewById<RecyclerView>(R.id.amfinal)

        recyclerFinal.layoutManager = LinearLayoutManager(this)

        recyclerFinal.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false)
       // recyclerFinal.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        recyclerFinal.adapter = AdaptadorPeliculas(generarDatosPeliculas().reversed() as ArrayList<Pelicula>,this)




/////////////////////




    }


    private fun generarTheaters():ArrayList<MovieStreaming>{
        var lista = ArrayList<MovieStreaming>()
        lista.add(MovieStreaming("The Pursuit of Love: S01","84%",R.drawable.sobresaliente))
        lista.add(MovieStreaming("Outer Banks:S02","60%",R.drawable.fresco))
        lista.add(MovieStreaming("Roswell, New Mexico:S03","40%",R.drawable.podrido))
        lista.add(MovieStreaming("The Demi Lovato Show:S01","28%",R.drawable.podrido))
        lista.add(MovieStreaming("FBoy Island:S01","43%",R.drawable.podrido))
        return  lista
    }



    private fun generarStreaming():ArrayList<MovieStreaming>{
        var lista = ArrayList<MovieStreaming>()
        lista.add(MovieStreaming("Mr Robot","89%",R.drawable.sobresaliente))
        lista.add(MovieStreaming("Breaking bad","95%",R.drawable.sobresaliente))
        lista.add(MovieStreaming("Elite","25%",R.drawable.podrido))
        lista.add(MovieStreaming("My hero Academia","29%",R.drawable.podrido))
        lista.add(MovieStreaming("Ex maquina","89%",R.drawable.sobresaliente))
        return  lista
    }

    private fun generarMovieTv():ArrayList<MovieStreaming>{
        var lista = ArrayList<MovieStreaming>()
        lista.add(MovieStreaming("Master of the Universe","96%",R.drawable.sobresaliente))
        lista.add(MovieStreaming("The white Lotus","85%",R.drawable.sobresaliente))
        lista.add(MovieStreaming("KATLA","99%",R.drawable.sobresaliente))
        lista.add(MovieStreaming("Sex/Life","23%",R.drawable.podrido))
        lista.add(MovieStreaming("American Horror Stories","37%",R.drawable.podrido))
        return  lista
    }

    private fun generarBanner():ArrayList<Banner>{
        var lista = ArrayList<Banner>()
        lista.add(Banner(R.drawable.banner11))
        lista.add(Banner(R.drawable.banner22))
        lista.add(Banner(R.drawable.banner33))
        lista.add(Banner(R.drawable.banner3))


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
                R.drawable.fresco
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
                R.drawable.podrido
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
                R.drawable.podrido
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
        val a = AdaptadorStreaming(generarStreaming(), this)
        a.filter(newText!!)
        return false

    }


}