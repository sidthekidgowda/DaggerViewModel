package com.example.daggerviewmodel.view

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.daggerviewmodel.R
import com.example.daggerviewmodel.databinding.IncrementDecrementFragmentBinding
import com.example.daggerviewmodel.viewmodel.IncrementDecrementViewModel
import kotlinx.android.synthetic.main.increment_decrement_fragment.*
import javax.inject.Inject

class IncrementDecrementFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory:  ViewModelProvider.Factory
    private lateinit var binding: IncrementDecrementFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.increment_decrement_fragment, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        //inject dagger
        (activity as MainActivity).appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //set up viewmodel
        val viewModel = ViewModelProvider(this, viewModelFactory).get(IncrementDecrementViewModel::class.java)
        binding.viewModel = viewModel
    }
}