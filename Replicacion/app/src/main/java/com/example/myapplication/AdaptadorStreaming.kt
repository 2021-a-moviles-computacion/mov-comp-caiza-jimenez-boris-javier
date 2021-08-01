package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.stream.Collector
import java.util.stream.Collectors
import java.util.stream.Stream

class AdaptadorStreaming(private var lista:ArrayList<MovieStreaming>, private var contexto:Context,
                         ):
RecyclerView.Adapter<AdaptadorStreaming.ViewHolder>(){



    inner class ViewHolder( var vista: View) : RecyclerView.ViewHolder(vista) {

        var nombre: TextView
        var certificado_imagen: ImageView
        var certificado: TextView

        init {
            nombre = vista.findViewById(R.id.pnombre)
            certificado_imagen = vista.findViewById(R.id.pcertificadoImagen)
            certificado = vista.findViewById(R.id.pcertificado)
           // originalItems!!.addAll(lista)

        }

    }




    fun filter(str:String){
        if(str.length == 0){
            lista.clear()
           // lista.addAll(originalItems!!)
        }else{
            lista.clear()
            lista.forEach{
                if(it.nombre.toLowerCase().contains(str)){
                    lista.add(it)
                }
            }
        }

        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.pruebas,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
     val movie = lista[position]
        holder.nombre.text = movie.nombre
        holder.certificado_imagen.setImageResource(movie.certificado_imagen)
        holder.certificado.text = movie.certificado
    }

    override fun getItemCount(): Int {
        return lista.size
    }
}