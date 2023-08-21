package com.example.taptadashboard.onboarding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.taptadashboard.R

class OnBoardingAdapter(private val onBoardingItems: List<OnBoardingItem>) :
RecyclerView.Adapter<OnBoardingAdapter.OnBoardingItemViewHolder>() {

    inner class OnBoardingItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val imageBoarding = view.findViewById<ImageView>(R.id.image_on_boarding)
        private val onBoardingTitle = view.findViewById<TextView>(R.id.on_boarding_title)
        private val onBoardingDescription = view.findViewById<TextView>(R.id.on_boarding_description)

        fun bind(onBoardingItem: OnBoardingItem) {
            imageBoarding.setImageResource(onBoardingItem.onBoardingImage)
            onBoardingTitle.text = onBoardingItem.title
            onBoardingDescription.text = onBoardingItem.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingItemViewHolder {
        return OnBoardingItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.on_boarding_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OnBoardingItemViewHolder, position: Int) {
        holder.bind(onBoardingItems[position])
    }

    override fun getItemCount(): Int {
        return onBoardingItems.size
    }
}