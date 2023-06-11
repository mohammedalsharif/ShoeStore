package com.example.shoestoreapp.shoeList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestoreapp.R
import com.example.shoestoreapp.model.Shoe
import timber.log.Timber

class ShoeListViewModel : ViewModel() {

    val shoeName = MutableLiveData<String>()
    val shoeSize = MutableLiveData<String>()
    val company = MutableLiveData<String>()
    val description = MutableLiveData<String>()

    private val _shoeList = MutableLiveData<MutableList<Shoe>>(mutableListOf())
    val shoeList: LiveData<MutableList<Shoe>> get() = _shoeList


    fun allFieldsIsNotBlank(): Boolean {
        return fieldIsNotBlank(shoeName)
                && fieldIsNotBlank(shoeSize)
                && fieldIsNotBlank(company)
                && fieldIsNotBlank(description)
    }

    private fun fieldIsNotBlank(data: MutableLiveData<String>): Boolean {
        return !data.value.isNullOrBlank()
    }

    fun saveNewShoe() {
        shoeList.value?.add(
            Shoe(
                shoeName.value ?: "",
                shoeSize.value ?: "",
                company.value ?: "",
                description.value ?: ""
            )
        )
    }

    fun shoeListIsEmpty():Boolean {
        return shoeList.value.isNullOrEmpty()
    }

    fun makeFieldsBlank() {
        shoeName.value = ""
        shoeSize.value = ""
        company.value = ""
        description.value = ""
    }

}