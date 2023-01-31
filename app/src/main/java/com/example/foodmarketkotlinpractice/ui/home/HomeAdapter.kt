package com.example.foodmarketkotlinpractice.ui.home

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodmarketkotlinpractice.R
import com.example.foodmarketkotlinpractice.data.entity.HomeModel
import com.example.foodmarketkotlinpractice.ui.detail.DetailActivity
import com.example.foodmarketkotlinpractice.ui.detail.DetailFragment

class HomeAdapter(private val listData : List<HomeModel>, private var ctx : Context) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvTtile : TextView = itemView.findViewById(R.id.tvTitle)
        var ivPoster : ImageView = itemView.findViewById(R.id.ivPoster)
        var rbFood : RatingBar = itemView.findViewById(R.id.rbFood)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_home_horizontal, parent, false)
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
        holder.itemView.setOnClickListener{
            val detail = Intent(ctx, DetailActivity::class.java)
            ctx.startActivity(detail)

        }
    }
}