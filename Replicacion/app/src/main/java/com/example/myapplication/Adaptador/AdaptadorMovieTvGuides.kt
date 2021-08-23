package com.example.myapplication.Adaptador

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.Datos.TvGuide

class AdaptadorMovieTvGuides (private var lista:ArrayList<TvGuide>, private var contexto: Context):
    RecyclerView.Adapter<AdaptadorMovieTvGuides.ViewHolder>(){


    inner class ViewHolder( var vista: View) : RecyclerView.ViewHolder(vista) {

        var imagen: ImageView
        val descripcion: TextView

        init {
            imagen = vista.findViewById(R.id.lastimage)
            descripcion = vista.findViewById(R.id.lasttext)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.the_last,parent,false)
        return ViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tv = lista[position]
        holder.imagen.setImageResource(tv.imagen)
        holder.descripcion.text = tv.descripcion


    }

    override fun getItemCount(): Int {
        return lista.size
    }

}