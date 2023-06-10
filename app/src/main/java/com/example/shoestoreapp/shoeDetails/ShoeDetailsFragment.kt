package com.example.shoestoreapp.shoeDetails

import android.inputmethodservice.Keyboard
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.shoestoreapp.R
import com.example.shoestoreapp.databinding.FragmentShoeDetailsBinding
import com.example.shoestoreapp.databinding.FragmentShoeListBinding
import com.example.shoestoreapp.shoeList.ShoeListViewModel
import com.example.shoestoreapp.util.hideKeyboard


class ShoeDetailsFragment : Fragment() {
    lateinit var binding: FragmentShoeDetailsBinding
    private val viewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_details, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel


        binding.btnCancel.setOnClickListener {
            viewModel.makeFieldsBlank()
            findNavController().popBackStack()
        }

        binding.btnSave.setOnClickListener {
            if (viewModel.allFieldsIsNotBlank()) {
                requireContext().hideKeyboard(it)
                viewModel.saveNewShoe()
                viewModel.makeFieldsBlank()
                findNavController().popBackStack()
            } else {
                Toast.makeText(
                    context,
                    getString(R.string.please_fill_all_fields),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        return binding.root
    }

}