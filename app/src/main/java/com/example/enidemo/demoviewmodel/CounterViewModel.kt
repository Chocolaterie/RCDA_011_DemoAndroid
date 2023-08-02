package com.example.enidemo.demoviewmodel

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CounterViewModel : ViewModel() {

    var counter = MutableLiveData<Int>();

    init {
        counter.value = 1
    }

    fun startCounter (){

        viewModelScope.launch {
            while (counter.value!! < 50) {
                delay(500)
                counter.value = counter.value!! + 1;
                Log.i("Test", counter.value!!.toString())

            }
        }
    }

    fun plus (){
        counter.value = counter.value!! + 1;
    }
}