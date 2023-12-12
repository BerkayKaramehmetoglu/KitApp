package com.example.kitapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val getBooks = GetBooks()

        getBooks.searchBooks("ücretsiz")
        //getBooks.searchBooks("Özcan Tekdemir")
    }
}
