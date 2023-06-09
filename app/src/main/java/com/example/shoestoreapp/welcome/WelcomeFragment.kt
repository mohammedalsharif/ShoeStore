package com.example.shoestoreapp.welcome

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.shoestoreapp.R
import com.example.shoestoreapp.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {
    private val viewModel: WelcomeViewModel by viewModels()
    private lateinit var binding: FragmentWelcomeBinding

    companion object {
        fun newInstance() = WelcomeFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_welcome, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnGoToInstructions.setOnClickListener{
            findNavController().navigate(R.id.action_welcomeFragment_to_instructionsFragment)
        }
    }


}