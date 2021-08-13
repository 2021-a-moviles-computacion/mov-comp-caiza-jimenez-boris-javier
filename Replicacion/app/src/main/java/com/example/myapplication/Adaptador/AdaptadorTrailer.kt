package com.example.myapplication.Adaptador

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.Datos.Trailer

//import info.jeovani.recyclerview.actividades.Detalles
//import info.jeovani.recyclerview.actividades.VisorImagen
//import kotlin.synthetic.main.elemento_lista_pelicula.view.*



class AdaptadorTrailer(private var lista: ArrayList<Trailer>, private var contexto: Context) : RecyclerView.Adapter<AdaptadorTrailer.ViewHolder>() {


    inner class ViewHolder( var vista: View) : RecyclerView.ViewHolder(vista) {

        var imagen:ImageView
        val titulo:TextView
        val descripcion:TextView

        init {
            imagen = vista.findViewById(R.id.imageVideos)
            titulo = vista.findViewById(R.id.titulovideos)
            descripcion = vista.findViewById(R.id.descripcionVideos)

        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.trailervideo,parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pelicula = lista[position]
        holder.imagen.setImageResource(pelicula.imagen)
        holder.titulo.text = pelicula.titulo
        holder.descripcion.text = pelicula.descripcion

    }



}