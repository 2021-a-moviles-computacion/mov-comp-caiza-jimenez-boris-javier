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
import com.example.myapplication.Actividades.VisorImagenes
import com.example.myapplication.Datos.Pelicula
import com.example.myapplication.R

class AdaptadorPeliculasFinal(private var lista: ArrayList<Pelicula>, private var contexto: Context) : RecyclerView.Adapter<AdaptadorPeliculasFinal.ViewHolder>() {


    inner class ViewHolder( var vista: View) : RecyclerView.ViewHolder(vista) {

        var imagen: ImageView
        val titulo: TextView
        val certificado: TextView
        var imagen_certificado: ImageView
        var clasificacion:TextView
        var duracion:TextView
        var fecha:TextView

        init {
            imagen = vista.findViewById(R.id.pruebaimagenprin)
            titulo = vista.findViewById(R.id.prueba2titutlo)
            certificado = vista.findViewById(R.id.prueba2certificado)
            imagen_certificado = vista.findViewById(R.id.prueba2certificadoimagen)
            clasificacion = vista.findViewById(R.id.pruebaclasificacion)
            duracion = vista.findViewById(R.id.prueba2duracion)
            fecha = vista.findViewById(R.id.prueba2fecha)


        }


    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.prueba2,parent,false)
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
        holder.clasificacion.setText(pelicula.clasificacion)
        holder.duracion.setText(pelicula.duracion.toString() + "m")
        holder.fecha.setText(pelicula.fecha)
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