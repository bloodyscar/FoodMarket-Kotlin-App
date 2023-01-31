package com.example.foodmarketkotlinpractice.ui.order

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodmarketkotlinpractice.R
import com.example.foodmarketkotlinpractice.data.entity.OrderModel

class InProgressAdapter(private val listData : List<OrderModel>) :
    RecyclerView.Adapter<InProgressAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var title : TextView = itemView.findViewById(R.id.tvTitle)
        var jumlah : TextView = itemView.findViewById(R.id.tvJumlahItem)
        var poster : ImageView = itemView.findViewById(R.id.ivPoster)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view  : View = LayoutInflater.from(parent.context).inflate(R.layout.item_order, parent, false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = listData[position]
        holder.title.text = data.title
        holder.jumlah.text = data.jumlah.toString()  + " Items"
    }
}