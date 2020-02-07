package com.example.daggerviewmodel.viewmodel

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

const val STARTING_COUNT: Int = 5

class IncrementDecrementViewModel @Inject constructor(): ViewModel(), IncrementDecrementAPI {

    private val countLiveData = MutableLiveData<Int>()
    private var currentCount = STARTING_COUNT

    init {
        countLiveData.value = currentCount
    }

    override fun integerCount(): LiveData<Int> {
        return countLiveData
    }

    override fun incrementCount() {
        countLiveData.value = ++currentCount
    }

    override fun decrementCount() {
        countLiveData.value = --currentCount
    }

}