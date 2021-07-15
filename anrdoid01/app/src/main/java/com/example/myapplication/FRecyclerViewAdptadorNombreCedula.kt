package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R.id.tv_likes

class FRecyclerViewAdptadorNombreCedula(private val contexto: GReculcerView,
                                        private val listaEntrenador: List<BEntrenador>,
                                        private val recyvlerView: RecyclerView
): RecyclerView.Adapter<FRecyclerViewAdptadorNombreCedula.MyViewHolder>() {
inner class MyViewHolder(view: View): RecyclerView.ViewHolder(view){

    val nombreTextView: TextView
    val cedulaTextView: TextView
    var likesTextView: TextView
    val accionButton:Button
    var numeroLikes = 0


    init{
        nombreTextView = view.findViewById(R.id.tv_nombre)
        cedulaTextView = view.findViewById(R.id.tv_cedula)
        accionButton = view.findViewById(R.id.btn_dar_like)
        likesTextView = view.findViewById(R.id.tv_likes)
        accionButton!!.setOnClickListener{
            this.añadirLike()
        }


    }

    fun añadirLike(){
        this.numeroLikes = this.numeroLikes +1
        likesTextView.text = this.numeroLikes.toString()
        contexto.aumentarTotalLikes()
    }


}


        //Setear el layout que vamos a utlizar
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).
                inflate(R.layout.recyvler_view_vista,
                parent,
                false)
            return  MyViewHolder(itemView)
    }

    //Setear los datos de cada iteración del arreglo
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val entrenador = listaEntrenador[position]
        holder.nombreTextView.text = entrenador.nombre
        holder.cedulaTextView.text = entrenador.descripcion
        holder.accionButton!!.text = "Like ${entrenador.nombre}"
        holder.likesTextView.text = "0"
    }
        //Tamaño del arreglo
    override fun getItemCount(): Int {
        return listaEntrenador.size
    }
}