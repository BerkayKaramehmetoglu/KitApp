package com.example.kitapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IBooksDao {
    @GET("volumes")
    fun searchBooks(
        @Query("q") query: String,
        @Query("maxResults") maxResults: Int,
        @Query("startIndex") startIndex: Int,
    ): Call<Books>
}