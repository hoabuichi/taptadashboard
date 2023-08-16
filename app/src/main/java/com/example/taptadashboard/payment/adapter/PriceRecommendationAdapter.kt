package com.example.taptadashboard.payment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.taptadashboard.R
import com.example.taptadashboard.databinding.RecyclePriceRecommendationItemBinding

class PriceRecommendationAdapter(private val priceList: ArrayList<String>): RecyclerView.Adapter<PriceRecommendationAdapter.MyViewHolder>() {
    class MyViewHolder(private val itemBinding: RecyclePriceRecommendationItemBinding): RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(priceText: String) {
            itemBinding.itemPriceText.text = priceText
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = RecyclePriceRecommendationItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(priceList[position])
    }

    override fun getItemCount(): Int {
        return priceList.size
    }
}