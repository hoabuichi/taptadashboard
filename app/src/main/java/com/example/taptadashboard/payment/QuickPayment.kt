package com.example.taptadashboard.payment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taptadashboard.databinding.FragmentQuickPaymentBinding
import com.example.taptadashboard.payment.adapter.PriceRecommendationAdapter
import com.example.taptadashboard.payment.viewmodel.QuickPaymentViewModel

class QuickPayment : Fragment() {

    private lateinit var binding : FragmentQuickPaymentBinding
    private lateinit var adapter : PriceRecommendationAdapter
    private val viewModel: QuickPaymentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentQuickPaymentBinding.inflate(inflater, container, false)
        binding.quickPayment = viewModel
        viewModel.currentAmountLiveData.observe(viewLifecycleOwner) { newAmount ->
            if (newAmount == "") {
                binding.itemPrice.text = "0 VND"
            } else {
                binding.itemPrice.text = newAmount + " VND"
            }
        }

        viewModel.currentTotalLiveData.observe(viewLifecycleOwner) { newAmount ->
            binding.quickTotalPrice.text = newAmount.toString() + " VND"
        }

        // recommended price list
        binding.priceRecommendationList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        viewModel.currentRecommendedPriceListLiveData.observe(viewLifecycleOwner) { newList ->
            adapter = PriceRecommendationAdapter(priceList = newList)
            binding.priceRecommendationList.adapter = adapter
        }

        return binding.root
    }
}