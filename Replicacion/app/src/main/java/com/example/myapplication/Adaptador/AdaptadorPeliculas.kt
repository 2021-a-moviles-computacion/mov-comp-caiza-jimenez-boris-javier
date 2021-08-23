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
import com.example.myapplication.Datos.Pelicula
import com.example.myapplication.R
import com.example.myapplication.Actividades.VisorImagenes

//import info.jeovani.recyclerview.actividades.Detalles
//import info.jeovani.recyclerview.actividades.VisorImagen
//import kotlin.synthetic.main.elemento_lista_pelicula.view.*



class AdaptadorPeliculas(private var lista: ArrayList<Pelicula>, private var contexto: Context) : RecyclerView.Adapter<AdaptadorPeliculas.ViewHolder>() {


    inner class ViewHolder( var vista: View) : RecyclerView.ViewHolder(vista) {

            var imagen:ImageView
            val titulo:TextView
            val certificado:TextView
            var imagen_certificado:ImageView

            init {
                imagen = vista.findViewById(R.id.elpIvPelicula)
                titulo = vista.findViewById(R.id.elpTvTitulo)
                certificado = vista.findViewById(R.id.elpTvcertificado)
                imagen_certificado = vista.findViewById(R.id.elpImImagenCer)


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
        holder.imagen.setImageResource(pelicula.idImagen)
        holder.titulo.text = pelicula.titulo
        holder.certificado.text = pelicula.certificado
        holder.imagen_certificado.setImageResource(pelicula.imagen_certificado)
        //////Imagen
        holder.imagen.setOnClickListener{
            contexto.startActivity(Intent(contexto, VisorImagenes::class.java).putExtra("pel",pelicula) )
        }
        //////Titulo
        holder.titulo.setOnClickListener{
            contexto.startActivity(Intent(contexto, VisorCalificacion::class.java).putExtra("pel",pelicula) )
        }
        //ImagenCertificado
        holder.imagen_certificado.setOnClickListener{
            contexto.startActivity(Intent(contexto, VisorCalificacion::class.java).putExtra("pel",pelicula) )
        }
        //Certificado
        holder.certificado.setOnClickListener{
            contexto.startActivity(Intent(contexto, VisorCalificacion::class.java).putExtra("pel",pelicula) )
        }

        
    }



}