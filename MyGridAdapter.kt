package com.example.recyclev

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyGridAdapter(private val driverlist : ArrayList<driver>): RecyclerView.Adapter<MyGridAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.grid_item_layout,
            parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {

        return driverlist.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.vImage.setImageResource(driverlist[position].img)
    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val vImage : ShapeableImageView = itemView.findViewById(R.id.image)
        val card : CardView = itemView.findViewById(R.id.card_item)
        val vNama : TextView = itemView.findViewById(R.id.name)
        val vDesc : TextView = itemView.findViewById(R.id.desc)

    }
}