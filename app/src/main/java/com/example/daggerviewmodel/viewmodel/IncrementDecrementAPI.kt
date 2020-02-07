package com.example.daggerviewmodel.viewmodel

import androidx.lifecycle.LiveData

interface IncrementDecrementAPI {

    fun integerCount(): LiveData<Int>

    fun incrementCount()
    fun decrementCount()

}