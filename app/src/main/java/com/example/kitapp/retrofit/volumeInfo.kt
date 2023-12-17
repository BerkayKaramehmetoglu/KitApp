package com.example.kitapp.retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class volumeInfo(
    @SerializedName("title")
    @Expose
    var title: String?,
    @SerializedName("subtitle")
    @Expose
    var subtitle: String?,
    @SerializedName("authors")
    @Expose
    var authors: List<String>?,//
    @SerializedName("publisher")
    @Expose
    var publisher: String?,
    @SerializedName("publishedDate")
    @Expose
    var publishedDate: String?,
    @SerializedName("description")
    @Expose
    var description: String?,
    @SerializedName("pageCount")
    @Expose
    var pageCount: Int?,
    @SerializedName("printType")
    @Expose
    var printType: String?,
    @SerializedName("categories")
    @Expose
    var categories: List<String>?,
    @SerializedName("imageLinks")
    @Expose
    var imageLinks: imageLinks?,
    @SerializedName("language")
    @Expose
    var language: String?,
)

