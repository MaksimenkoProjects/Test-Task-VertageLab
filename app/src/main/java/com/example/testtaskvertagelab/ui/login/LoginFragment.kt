package com.example.testtaskvertagelab.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.testtaskvertagelab.R
import com.example.testtaskvertagelab.databinding.FragmentLoginBinding
import com.example.testtaskvertagelab.ui.ViewModelFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class LoginFragment : DaggerFragment() {

    @Inject
    lateinit var factory: ViewModelFactory
    lateinit var viewModel: LoginViewModel

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        androidInjector().inject(this)
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        viewModel = ViewModelProvider(this, factory).get(LoginViewModel::class.java)
        binding.viewModel = viewModel
        return binding.root
    }

}