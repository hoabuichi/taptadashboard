package com.example.taptadashboard.payment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.taptadashboard.R

class PriceRecommendationAdapter(private val priceList: ArrayList<String>): RecyclerView.Adapter<PriceRecommendationAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val price: TextView = itemView.findViewById(R.id.item_price_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycle_price_recommendation_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.price.text = priceList[position]
    }

    override fun getItemCount(): Int {
        return priceList.size
    }
}