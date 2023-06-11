package com.example.shoestoreapp.login

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.shoestoreapp.R
import com.example.shoestoreapp.databinding.FragmentLoginBinding
import com.example.shoestoreapp.util.hideKeyboard

class LoginFragment : Fragment() {
    private val viewModel: LoginViewModel by viewModels()
    private lateinit var binding: FragmentLoginBinding

    companion object {
        fun newInstance() = LoginFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loginButton.setOnClickListener(::loginOperation)
    }

    private fun loginOperation(view: View) {
        if (viewModel.loginFieldsIsNotBlank()) {
            requireContext().hideKeyboard(requireView())
            findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
        } else {
            Toast.makeText(
                context,
                getString(R.string.please_enter_email_and_password),
                Toast.LENGTH_LONG
            ).show()
        }
    }


}