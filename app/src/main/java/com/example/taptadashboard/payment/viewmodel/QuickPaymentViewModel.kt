package com.example.taptadashboard.payment.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class QuickPaymentViewModel: ViewModel() {
    var keyboardCount: Long = 0
    var currentAmount: String = ""
    var totalAmount: Long = 0
    private val recommendedBase: ArrayList<Long> = arrayListOf(10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000)
    var recommendedPriceList: ArrayList<Long> = arrayListOf(1000, 10000, 100000, 1000000, 10000000, 100000000)

    val currentRecommendedPriceListLiveData: MutableLiveData<ArrayList<Long>> by lazy {
        MutableLiveData<ArrayList<Long>>()
    }

    // for vibration effect
    val keyboardCountLiveData: MutableLiveData<Long> by lazy {
        MutableLiveData<Long>()
    }

    val currentAmountLiveData: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val currentTotalLiveData: MutableLiveData<Long> by lazy {
        MutableLiveData<Long>()
    }



    fun onNewKeyboard(number: Int){
        keyboardCountLiveData.value = ++keyboardCount
        if(currentAmount == "" && (number == 0 || number == 10 || number == 11 )) {
            return
        }

        if(currentAmount != "" && currentAmount.toLong() > 999999999 && number != 11) {
            return
        }

        if(number == 10) {
            if(totalAmount + currentAmount.toLong() > 999999999) {
                return
            }
            totalAmount += currentAmount.toLong()
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
        updateRecommendedPriceList()
    }

    fun onRecommendedPriceClick(index: Int) {
        currentAmount = recommendedPriceList[index].toString()
        currentAmountLiveData.value =  currentAmount
    }

    private fun updateRecommendedPriceList() {
        if(currentAmount == "") {
            recommendedPriceList = recommendedBase.filter { value -> value >= 1000 } as ArrayList<Long>
            currentRecommendedPriceListLiveData.value = recommendedPriceList
            return
        }
        recommendedPriceList = arrayListOf()
        for(basePrice in recommendedBase) {
            val tempPrice = basePrice * currentAmount.toLong()
            if (tempPrice in 1000..1000000000) {
                recommendedPriceList.add(tempPrice)
            }
        }
        currentRecommendedPriceListLiveData.value = recommendedPriceList
    }
}