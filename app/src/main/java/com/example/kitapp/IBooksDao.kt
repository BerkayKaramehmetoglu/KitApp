package com.example.kitapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IBooksDao {

    //max Result start Index
    //https://www.googleapis.com/books/v1/volumes?q=search+terms&maxResults=40&startIndex=20


    /*@GET("volumes?q=sefiller:keyes&key=KEY")
    fun getAllBooks(): Call<Books>*/

    //İstenen Kitabı Getirir
    @GET("volumes")
    fun searchBooksTitle(
        @Query("q") query: String,
        @Query("maxResults") maxResults: Int,
        @Query("startIndex") startIndex: Int
    ): Call<Books>

    //İstenen Kategoriyi Getirir
    @GET("volumes")
    fun getCategory(
        @Query("q") query: String,
        //@Query("maxResults") maxResults: Int
    ): Call<Books>

    //Bedava Kitap

}