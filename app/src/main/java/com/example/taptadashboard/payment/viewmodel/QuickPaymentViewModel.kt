package com.example.taptadashboard.payment.viewmodel

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class QuickPaymentViewModel: ViewModel() {
    val currentAmountLiveData: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun onNewKeyboard(number: Int){
        if(currentAmountLiveData.value == null) {
            currentAmountLiveData.value =  number.toString()
        } else {
            currentAmountLiveData.value =  currentAmountLiveData.value + number.toString()
        }
    }

    fun onClearTypingPrice(){
        currentAmountLiveData.value =  null
    }
}