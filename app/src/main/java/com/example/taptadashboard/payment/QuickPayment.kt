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
    private lateinit var priceList: ArrayList<String>
    private val viewModel: QuickPaymentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentQuickPaymentBinding.inflate(inflater, container, false)
        binding.quickPayment = viewModel
        viewModel.currentAmountLiveData.observe(viewLifecycleOwner, Observer<String> { newAmount ->
            binding.itemPrice.text = newAmount
        })
        priceList = arrayListOf<String>()
        priceList.add("1000 VND")
        priceList.add("10000 VND")
        priceList.add("100000 VND")
        priceList.add("100000 VND")
        priceList.add("1000000 VND")
        priceList.add("10000000 VND")
        priceList.add("100000000 VND")
        adapter = PriceRecommendationAdapter(priceList = priceList)
        binding.priceRecommendationList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.priceRecommendationList.adapter = adapter


//        binding.btnOne.setOnClickListener {
//            Log.v("Keyboard: ", 1.toString());
//        }
        return binding.root
    }
}