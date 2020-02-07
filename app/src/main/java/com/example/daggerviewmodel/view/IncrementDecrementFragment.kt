package com.example.daggerviewmodel.view

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.daggerviewmodel.R
import javax.inject.Inject

class IncrementDecrementFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory:  ViewModelProvider.Factory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.increment_decrement_fragment, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        //inject dagger
        (activity as MainActivity).appComponent.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //set up viewmodel
    }
}