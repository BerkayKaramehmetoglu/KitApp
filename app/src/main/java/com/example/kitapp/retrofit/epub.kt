package com.example.kitapp.retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class epub(
    @SerializedName("isAvailable")
    @Expose
    var isAvailable: Boolean
)
