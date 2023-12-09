package com.example.kitapp

class ApiUtils{

    companion object{

        val BASE_URL = "https://www.googleapis.com/books/v1/"

        fun getIBooksDao():IBooksDao{
            return RetrofitClient.getClient(BASE_URL).create(IBooksDao::class.java)
        }

    }

}