package com.example.myapplication.Adaptador

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Datos.Banner
import com.example.myapplication.R

class AdaptadorBanner2 (
    val mList: List<Banner>
):RecyclerView.Adapter<AdaptadorBanner2.ViewPagerViewHolder>(){
    inner class ViewPagerViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.elemento_banner,parent,false)
        return ViewPagerViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {


        val curmList = mList[position]

        val slideImg =  holder.itemView.findViewById<ImageView>(R.id.banner_image)
        slideImg.setImageResource(curmList.Imagen)

    }

    override fun getItemCount(): Int {
        return mList.size
    }

}