package com.example.taptadashboard.payment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.taptadashboard.R
import com.example.taptadashboard.databinding.RecyclePriceRecommendationItemBinding
import com.example.taptadashboard.utils.formatter
import java.util.Locale

class PriceRecommendationAdapter(private val priceList: ArrayList<Long>): RecyclerView.Adapter<PriceRecommendationAdapter.MyViewHolder>() {
    class MyViewHolder(private val itemBinding: RecyclePriceRecommendationItemBinding): RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(priceText: Long) {
            itemBinding.itemPriceText.text = itemView.context.getString(R.string.price_text, formatter(priceText, Locale.US))
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