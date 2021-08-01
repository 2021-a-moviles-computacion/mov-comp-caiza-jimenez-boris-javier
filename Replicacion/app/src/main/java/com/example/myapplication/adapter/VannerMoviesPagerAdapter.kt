package com.example.myapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.example.myapplication.BannerMocies
import com.example.myapplication.R

class VannerMoviesPagerAdapter(var context:Context, var bannerMovieList: List<BannerMocies>): PagerAdapter() {
    override fun getCount(): Int {
        return bannerMovieList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return false
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        var view:View = LayoutInflater.from(context).inflate(R.layout.banner_movie_layout, null)
        var bannerImage:ImageView =  view.findViewById(R.id.banner_image)


        Glide.with(context).load(bannerMovieList[position].imagenUrl).into(bannerImage)
        container.addView(view)

        return view

    }
}