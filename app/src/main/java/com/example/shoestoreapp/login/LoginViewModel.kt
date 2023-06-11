package com.example.shoestoreapp.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    fun loginFieldsIsNotBlank(): Boolean {
        return fieldIsNotBlank(email)
                && fieldIsNotBlank(password)

    }

    private fun fieldIsNotBlank(data: MutableLiveData<String>): Boolean {
        return !data.value.isNullOrBlank()
    }
}