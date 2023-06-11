package com.example.shoestoreapp.model

import android.os.Parcelable
import androidx.versionedparcelable.ParcelField
import kotlinx.parcelize.Parcelize

@Parcelize
data class Shoe(val name: String , val shoeSize: String, val company: String ,val description: String): Parcelable