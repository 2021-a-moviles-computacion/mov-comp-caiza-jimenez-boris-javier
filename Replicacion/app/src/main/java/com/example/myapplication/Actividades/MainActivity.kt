package com.example.myapplication.Actividades

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.Adaptador.*
import com.example.myapplication.Datos.*
import com.example.myapplication.R
import kotlin.collections.ArrayList
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity(){

    private var lstSlides= ArrayList<Banner>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //////////////Peliculas
        var recyclerPelicula = findViewById<RecyclerView>(R.id.amRvPeliculas)

       recyclerPelicula.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false)
        // recycler.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        recyclerPelicula.adapter = AdaptadorPeliculas(generarDatosPeliculas(),this)



        //////////////Banner
      /* var recyclerBanner = findViewById<RecyclerView>(R.id.amRvBanner)



        recyclerBanner.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false)
        // recycler.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        recyclerBanner.adapter = AdaptadorBanner(generarBanner(),this)*/


        //Slider page
        val adapter = AdaptadorBanner2(generarBanner())
        val pager = findViewById<ViewPager2>(R.id.slidier_pager)
        pager.adapter = adapter

        /////////////////////////////
//Timer del SliderPage
        /*var timer = timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                pager.post(Runnable {
                    Log.d("viewPager", "" + pager.currentItem)
                    if(pager.currentItem<lstSlides.size-1){
                        pager.currentItem = pager.currentItem+1
                    }else{
                        pager.currentItem=0
                    }
                })
            }
        }, 2000, 3000)*/


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




        ///////////////////// Parte final


        var recyclerLast = findViewById<RecyclerView>(R.id.thelast)

        recyclerLast.layoutManager = LinearLayoutManager(this)

         //recyclerStraming.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL ,false)
        //recyclerLast.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        recyclerLast.adapter = AdaptadorMovieTvGuides(generarTvGuide(),this)

        /////////////////DC movies

        var recyclerPeliculaDC = findViewById<RecyclerView>(R.id.dc)

        recyclerPeliculaDC.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false)
        // recycler.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        recyclerPeliculaDC.adapter = AdaptadorPeliculas(generarDatosPeliculasDC(),this)

        ///Trailers

        var recyclerTrailer = findViewById<RecyclerView>(R.id.amTrailers)

        recyclerTrailer.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false)
        // recycler.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        recyclerTrailer.adapter = AdaptadorTrailer(generarTrailer(),this)


        val boton1 = findViewById<Button>(R.id.boton1)
        boton1.setOnClickListener{
            abrirActividad(ListaPeliculas::class.java)
        }

        val boton2 = findViewById<Button>(R.id.boton2)
        boton2.setOnClickListener{
            abrirActividad(ListaPeliculas::class.java)
        }

        val boton3 = findViewById<Button>(R.id.boton3)
        boton3.setOnClickListener{
            abrirActividad(ListaPeliculas::class.java)
        }

        val boton4 = findViewById<Button>(R.id.boton4)
        boton4.setOnClickListener{
            abrirActividad(ListaPeliculas::class.java)
        }

        val boton5 = findViewById<Button>(R.id.boton5)
        boton5.setOnClickListener{
            abrirActividad(ListaPeliculas::class.java)
        }

        val boton6 = findViewById<Button>(R.id.boton6)
        boton6.setOnClickListener{
            abrirActividad(ListaPeliculas::class.java)
        }

        val boton7 = findViewById<Button>(R.id.boton7)
        boton7.setOnClickListener{
            abrirActividad(ListaPeliculas::class.java)
        }

        val boton8 = findViewById<Button>(R.id.boton8)
        boton8.setOnClickListener{
            abrirActividad(ListaPeliculas::class.java)
        }



    }

    fun abrirActividad(clase: Class<*>){
        val intentExplicito = Intent( //Intent es una clase, solamente para que este bien contextualizado.
            this,
            clase
        )
        startActivity(intentExplicito) //Lo heredamos de la clase.
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

    private fun generarTvGuide():ArrayList<TvGuide>{
        var lista = ArrayList<TvGuide>()
        lista.add(TvGuide(R.drawable.image001,"200 Best Horror Movies of All Time"))
        lista.add(TvGuide(R.drawable.image003,"200 Fresh Movies to Watach Online for free"))
        lista.add(TvGuide(R.drawable.image005,"2021's Most Anticipated Movies"))
        lista.add(TvGuide(R.drawable.image007,"Best Netflix Series to Watach Rigth Now"))
        return  lista
    }


    private fun generarTheaters():ArrayList<MovieStreaming>{
        var lista = ArrayList<MovieStreaming>()
        lista.add(MovieStreaming("The Pursuit of Love: S01","84%", R.drawable.sobresaliente,"PG-13","2015","Fantasía",147,R.drawable.sobresaliente,"95%"))
        lista.add(MovieStreaming("Outer Banks:S02","60%", R.drawable.fresco,"PG-13","2015","Fantasía",147,R.drawable.sobresaliente,"95%"))
        lista.add(MovieStreaming("Roswell, New Mexico:S03","40%", R.drawable.podrido,"PG-13","2015","Fantasía",147,R.drawable.sobresaliente,"95%"))
        lista.add(MovieStreaming("The Demi Lovato Show:S01","28%", R.drawable.podrido,"PG-13","2015","Fantasía",147,R.drawable.sobresaliente,"95%"))
        lista.add(MovieStreaming("FBoy Island:S01","43%", R.drawable.podrido,"PG-13","2015","Fantasía",147,R.drawable.sobresaliente,"95%"))
        return  lista
    }



    private fun generarStreaming():ArrayList<MovieStreaming>{
        var lista = ArrayList<MovieStreaming>()
        lista.add(MovieStreaming("Mr Robot","89%", R.drawable.sobresaliente,"PG-13","2015","Fantasía",147,R.drawable.sobresaliente,"95%"))
        lista.add(MovieStreaming("Breaking bad","95%", R.drawable.sobresaliente,"PG-13","2015","Fantasía",147,R.drawable.sobresaliente,"95%"))
        lista.add(MovieStreaming("Elite","25%", R.drawable.podrido,"PG-13","2015","Fantasía",147,R.drawable.sobresaliente,"95%"))
        lista.add(MovieStreaming("My hero Academia","29%", R.drawable.podrido,"PG-13","2015","Fantasía",147,R.drawable.sobresaliente,"95%"))
        lista.add(MovieStreaming("Ex maquina","89%", R.drawable.sobresaliente,"PG-13","2015","Fantasía",147,R.drawable.sobresaliente,"95%"))
        return  lista
    }

    private fun generarMovieTv():ArrayList<MovieStreaming>{
        var lista = ArrayList<MovieStreaming>()
        lista.add(MovieStreaming("Master of the Universe","96%", R.drawable.sobresaliente,"PG-13","2015","Fantasía",147,R.drawable.sobresaliente,"95%"))
        lista.add(MovieStreaming("The white Lotus","85%", R.drawable.sobresaliente,"PG-13","2015","Fantasía",147,R.drawable.sobresaliente,"95%"))
        lista.add(MovieStreaming("KATLA","99%", R.drawable.sobresaliente,"PG-13","2015","Fantasía",147,R.drawable.sobresaliente,"95%"))
        lista.add(MovieStreaming("Sex/Life","23%", R.drawable.podrido,"PG-13","2015","Fantasía",147,R.drawable.sobresaliente,"95%"))
        lista.add(MovieStreaming("American Horror Stories","37%", R.drawable.podrido,"PG-13","2015","Fantasía",147,R.drawable.sobresaliente,"95%"))
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