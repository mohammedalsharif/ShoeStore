package com.example.shoestoreapp.shoeList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.shoestoreapp.R
import com.example.shoestoreapp.databinding.ItemShoeBinding
import com.example.shoestoreapp.model.Shoe

class ShoeAdapter(var listShoe: List<Shoe> = emptyList()) :
    RecyclerView.Adapter<ShoeAdapter.ShoeViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoeViewHolder {
        return ShoeViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_shoe,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = listShoe.size

    override fun onBindViewHolder(holder: ShoeViewHolder, position: Int) {
        holder.binding.shoes = listShoe[position]
    }

    inner class ShoeViewHolder(val binding: ItemShoeBinding) : RecyclerView.ViewHolder(binding.root)
}