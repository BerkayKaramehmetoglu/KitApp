package com.example.kitapp.retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class saleInfo(
    @SerializedName("isEbook")
    @Expose
    var isEbook: Boolean
)
