package com.example.kitapp

import com.example.kitapp.retrofit.accessInfo
import com.example.kitapp.retrofit.saleInfo
import com.example.kitapp.retrofit.volumeInfo
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class items(
    @SerializedName("id")
    @Expose
    var id: String,
    @SerializedName("volumeInfo")
    @Expose
    var volumeInfo: volumeInfo,
    @SerializedName("saleInfo")
    @Expose
    var saleInfo: saleInfo,
    @SerializedName("accessInfo")
    @Expose
    var accessInfo: accessInfo
)
