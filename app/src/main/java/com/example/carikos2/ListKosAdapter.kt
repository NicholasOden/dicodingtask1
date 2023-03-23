package com.example.carikos2

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListKosAdapter(private val listKos: ArrayList<Kos>): RecyclerView.Adapter<ListKosAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.text_item_name)
        val tvLocation: TextView = itemView.findViewById(R.id.text_item_location)
        val tvDistance: TextView = itemView.findViewById(R.id.text_item_distance)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_row_kos, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (photo, name, location, distance) = listKos[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvLocation.text = location
        holder.tvDistance.text = distance
        holder.itemView.setOnClickListener {
        }
    }

    override fun getItemCount(): Int {
        return listKos.size
    }
}