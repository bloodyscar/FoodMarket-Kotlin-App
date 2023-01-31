package com.example.foodmarketkotlinpractice.ui.profile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.foodmarketkotlinpractice.R
import com.example.foodmarketkotlinpractice.data.entity.AccountModel

class AccountAdapter(private val listData : List<AccountModel>) : RecyclerView.Adapter<AccountAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvTtile : TextView = itemView.findViewById(R.id.tvAccount)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_account, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val (title) = listData[position]
        holder.tvTtile.text = title
    }
}