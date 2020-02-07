package com.example.daggerviewmodel.viewmodel

import androidx.lifecycle.LiveData

interface IncrementDecrementAPI {

    fun integerCountLiveData(): LiveData<Int>

    fun incrementCount()
    fun decrementCount()

}