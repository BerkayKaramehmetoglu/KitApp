package com.example.kitapp

import com.example.kitapp.items
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Books(
    @SerializedName("totalItems")
    @Expose
    var totalItems: Int,
    @SerializedName("items")
    @Expose
    var items: List<items>?,
) {


}