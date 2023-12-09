package com.example.kitapp.retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class accessInfo(
    @SerializedName("country")
    @Expose
    var country: String,
    @SerializedName("viewability")
    @Expose
    var viewability: String,
    @SerializedName("epub")
    @Expose
    var epub: epub,
    @SerializedName("pdf")
    @Expose
    var pdf: pdf,
    @SerializedName("webReaderLink")
    @Expose
    var webReaderLink: String,
    @SerializedName("accessViewStatus")
    @Expose
    var accessViewStatus: String
)
