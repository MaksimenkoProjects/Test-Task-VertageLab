package com.example.testtaskvertagelab.ui.map

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.testtaskvertagelab.R
import com.example.testtaskvertagelab.databinding.FragmentMapBinding
import com.example.testtaskvertagelab.ui.ViewModelFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class MapFragment : DaggerFragment() {

    @Inject
    lateinit var factory: ViewModelFactory
    lateinit var viewModel: MapViewModel

    private var _binding: FragmentMapBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        androidInjector().inject(this)
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_map, container, false)
        viewModel = ViewModelProvider(this, factory).get(MapViewModel::class.java)
        binding.viewModel = viewModel
        return binding.root
    }

}