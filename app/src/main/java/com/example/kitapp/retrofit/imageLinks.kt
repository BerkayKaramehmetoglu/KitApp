package com.example.kitapp.retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class imageLinks(
    @SerializedName("smallThumbnail")
    @Expose
    var extraLarge: String
)
