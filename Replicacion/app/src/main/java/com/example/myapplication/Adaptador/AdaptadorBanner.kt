package com.example.myapplication.Adaptador

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Datos.Banner
import com.example.myapplication.R

class AdaptadorBanner(private var lista:ArrayList<Banner>, private var contexo:Context):
RecyclerView.Adapter<AdaptadorBanner.ViewHolder>(){

    inner class ViewHolder( var vista: View) : RecyclerView.ViewHolder(vista) {

        var imagen: ImageView

        init {
            imagen = vista.findViewById(R.id.banner_image)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.elemento_banner,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val Banner = lista[position]
        holder.imagen.setImageResource(Banner.Imagen)

    }

    override fun getItemCount(): Int {
      return  lista.size
    }

}