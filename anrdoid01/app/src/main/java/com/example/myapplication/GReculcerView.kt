package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GReculcerView : AppCompatActivity() {
    var totalLikes = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_greculcer_view)

        val listEntrenador = arrayListOf<BEntrenador>()
        val ligaPokemos = DLiga("Kanto","Liga Kanto")
        listEntrenador.add(BEntrenador("Boris","1755185749",ligaPokemos))
        listEntrenador.add(BEntrenador("Javier","123457891",ligaPokemos))

        val recyclerViewEntrenadores = findViewById<RecyclerView>(R.id.rv_entrenadores)

        //Iniciar recycler view

        inicarRecyvlerView(listEntrenador, this, recyclerViewEntrenadores)
    }



    fun inicarRecyvlerView(lista: List<BEntrenador>, actividad: GReculcerView,
    recyclerView: RecyclerView){
        val adaptador = FRecyclerViewAdptadorNombreCedula(actividad, lista, recyclerView)
        recyclerView.adapter = adaptador
        recyclerView.itemAnimator = androidx.recyclerview.widget.DefaultItemAnimator()
        recyclerView.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(actividad)
        adaptador.notifyDataSetChanged()
    }

    fun aumentarTotalLikes(){
       totalLikes = totalLikes +1
        val textView = findViewById<TextView>(R.id.tv_total_likes)
        textView.text = totalLikes.toString()
    }
}