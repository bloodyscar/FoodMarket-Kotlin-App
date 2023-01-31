package com.example.foodmarketkotlinpractice.ui.home.newtaste

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodmarketkotlinpractice.R
import com.example.foodmarketkotlinpractice.data.entity.HomeModel


class HomeNewTasteAdapter(private val listData : List<HomeModel>) : RecyclerView.Adapter<HomeNewTasteAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvTtile : TextView = itemView.findViewById(R.id.tvTitle)
        var ivPoster : ImageView = itemView.findViewById(R.id.ivPoster)
        var rbFood : RatingBar = itemView.findViewById(R.id.rbFood)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_home_vertical, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val (title, poster, rating) = listData[position]
        holder.tvTtile.text = title
        Glide.with(holder.itemView.context).load(holder.itemView.context.resources.getDrawable(R.drawable.iv_sample_product)).into(holder.ivPoster)
        holder.rbFood.rating = rating
    }
}