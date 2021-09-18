package com.example.examens2.ui.adaptadores

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.examens2.R

import com.example.examens2.ui.clases.Pelicula


class AdaptadorPelicula(private var lista: ArrayList<Pelicula>, val contexto: Context) : RecyclerView.Adapter<AdaptadorPelicula.ViewHolder>() {


    inner class ViewHolder( var vista: View) : RecyclerView.ViewHolder(vista) {

        var imagen:ImageView
        val calificacion:TextView


        init {
            imagen = vista.findViewById(R.id.elpIvPelicula)
            calificacion = vista.findViewById(R.id.tv_calificacion)



        }


    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.elemento_lista_pelicula,parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pelicula = lista[position]
        holder.imagen.setImageResource(pelicula.ImagePortada)
        holder.calificacion.text = pelicula.Calificacion

        //////Imagen
        holder.imagen.setOnClickListener{
            //contexto.startActivity(Intent(contexto, VisorImagenes::class.java).putExtra("pel",pelicula) )

        }
        //////Titulo
        /* holder.titulo.setOnClickListener{
             contexto.startActivity(Intent(contexto, VisorCalificacion::class.java).putExtra("pel",pelicula) )
         }
         //ImagenCertificado
         holder.imagen_certificado.setOnClickListener{
             contexto.startActivity(Intent(contexto, VisorCalificacion::class.java).putExtra("pel",pelicula) )
         }
         //Certificado
         holder.certificado.setOnClickListener{
             contexto.startActivity(Intent(contexto, VisorCalificacion::class.java).putExtra("pel",pelicula) )
         }*/


    }



}