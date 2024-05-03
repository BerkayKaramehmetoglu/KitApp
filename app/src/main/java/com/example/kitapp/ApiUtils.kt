package com.example.kitapp

import android.util.Log

class ApiUtils{

    companion object{

        private const val BASE_URL = "https://www.googleapis.com/books/v1/"

        fun getIBooksDao():IBooksDao{
            return RetrofitClient.getClient(BASE_URL).create(IBooksDao::class.java)
        }

    }

}