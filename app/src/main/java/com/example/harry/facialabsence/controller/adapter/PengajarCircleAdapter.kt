package com.example.harry.facialabsence.controller.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.harry.facialabsence.Model.Pengajar
import com.example.harry.facialabsence.R
import com.squareup.picasso.Picasso

class PengajarCircleAdapter(data:List<Pengajar>) : RecyclerView.Adapter<PengajarCircleAdapter.ViewHolder>() {
    private val data = data


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view: View = LayoutInflater.from(p0.context).inflate(R.layout.circle_image, p0, false)
        val viewHolder = ViewHolder(view)
        return viewHolder

    }

    override fun getItemCount(): Int {
       return data.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        Picasso.get().load(data.get(p1).image).into(p0.pengajarImage);
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val pengajarImage:ImageView? = itemView?.findViewById(R.id.pengajarImage)
    }


}