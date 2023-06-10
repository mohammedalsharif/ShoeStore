package com.example.shoestoreapp.shoeList

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.shoestoreapp.R
import com.example.shoestoreapp.databinding.FragmentShoeListBinding
import com.example.shoestoreapp.model.Shoe

class ShoeListFragment : Fragment() {
    private val viewModel: ShoeListViewModel by activityViewModels()
    private lateinit var binding: FragmentShoeListBinding

    companion object {
        fun newInstance() = ShoeListFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        createMenu()
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
        viewModel.shoeList.observe(viewLifecycleOwner) {
            binding.shoeList.apply {
                adapter = ShoeAdapter(it)
                layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            }
        }
        binding.btnAddShoe.setOnClickListener{
            findNavController().navigate(R.id.action_shoeListFragment_to_shoeDetailsFragment)
        }


        return binding.root
    }

    private fun createMenu() {
        requireActivity().addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.logout_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                when (menuItem.itemId) {
                    R.id.item_logout -> {
                        findNavController().navigate(R.id.action_shoeListFragment_to_loginFragment)
                    }
                }
                return false
            }

        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }


}