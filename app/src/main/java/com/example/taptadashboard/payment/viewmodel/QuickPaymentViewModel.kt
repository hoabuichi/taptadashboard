package com.example.taptadashboard.payment.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class QuickPaymentViewModel: ViewModel() {

    var currentAmount: String = ""
    var totalAmount: Long = 0
    private val recommendedBase: ArrayList<Long> = arrayListOf(1000, 10000, 100000, 1000000, 10000000, 100000000)
    var recommendedPriceList: ArrayList<Long> = recommendedBase

    val currentRecommendedPriceListLiveData: MutableLiveData<ArrayList<Long>> by lazy {
        MutableLiveData<ArrayList<Long>>()
    }

    val currentAmountLiveData: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val currentTotalLiveData: MutableLiveData<Long> by lazy {
        MutableLiveData<Long>()
    }

    fun onNewKeyboard(number: Int){
        if(currentAmount == "" && (number == 0 || number == 10 || number == 11 )) {
            return
        }

        if(number == 10) {
            totalAmount += currentAmount.toInt()
            currentTotalLiveData.value = totalAmount
            onClearTypingPrice()
            return
        }

        if(number == 11) {
            currentAmount = currentAmount.dropLast(1)
            currentAmountLiveData.value = currentAmount
            updateRecommendedPriceList()
            return
        }

        currentAmount += number.toString()
        currentAmountLiveData.value = currentAmount

        updateRecommendedPriceList()
    }

    fun onClearTypingPrice(){
        currentAmount = ""
        currentAmountLiveData.value =  currentAmount
        recommendedPriceList = recommendedBase
        currentRecommendedPriceListLiveData.value = recommendedPriceList
    }

    private fun updateRecommendedPriceList() {
        if(currentAmount == "") {
            recommendedPriceList = recommendedBase
            currentRecommendedPriceListLiveData.value = recommendedPriceList
            return
        }
        recommendedPriceList = arrayListOf()
        for(basePrice in recommendedBase) {
            val tempPrice = basePrice * currentAmount.toInt()
            if (tempPrice < 1000000000) {
                recommendedPriceList.add(tempPrice)
            }
        }
        currentRecommendedPriceListLiveData.value = recommendedPriceList
    }
}