package com.example.shoestoreapp.shoeList

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.shoestoreapp.R
import com.example.shoestoreapp.databinding.FragmentShoeListBinding
import com.example.shoestoreapp.model.Shoe

class ShoeListFragment : Fragment() {
    private val viewModel: ShoeListViewModel by viewModels()
    private lateinit var binding: FragmentShoeListBinding

    companion object {
        fun newInstance() = ShoeListFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
        binding.shoeList.apply {
            adapter=ShoeAdapter(listOf(
                Shoe("Nike",R.drawable.img_shoes,"$200"),
                Shoe("Nike",R.drawable.img_shoes,"$200"),
                Shoe("Nike",R.drawable.img_shoes,"$200"),
                Shoe("Nike",R.drawable.img_shoes,"$200"),
                Shoe("Nike",R.drawable.img_shoes,"$200"),

            ))
            layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        }
        binding
        return binding.root
    }


}