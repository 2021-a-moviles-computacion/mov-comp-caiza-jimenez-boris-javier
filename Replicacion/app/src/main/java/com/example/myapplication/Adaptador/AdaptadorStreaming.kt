package com.example.myapplication.Adaptador

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Actividades.VisorCalificacion
import com.example.myapplication.Datos.MovieStreaming
import com.example.myapplication.R

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







    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.pruebas,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
     val movie = lista[position]
        holder.nombre.text = movie.nombre
        holder.certificado_imagen.setImageResource(movie.certificado_imagen)
        holder.certificado.text = movie.certificado



        holder.nombre.setOnClickListener{
            contexto.startActivity(Intent(contexto, visor_calificacion_2::class.java).putExtra("mov",movie) )
        }

        holder.certificado.setOnClickListener{
            contexto.startActivity(Intent(contexto, visor_calificacion_2::class.java).putExtra("mov",movie) )
        }

        holder.certificado_imagen.setOnClickListener{
            contexto.startActivity(Intent(contexto, visor_calificacion_2::class.java).putExtra("mov",movie) )
        }


    }

    override fun getItemCount(): Int {
        return lista.size
    }
}