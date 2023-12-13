package com.example.kitapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.kitapp.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    private lateinit var desing:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        desing = DataBindingUtil.setContentView(this@MainActivity,R.layout.activity_main)

        val getBooks = GetBooks()

        desing.button.setOnClickListener {
            val url = "https://books.google.com/books/content?id=UfKKDwAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api"
            Picasso.get()
                .load(url)
                .resize(500,500)
                .into(desing.imageView)
        }
        getBooks.searchBooks("ücretsiz")
    }
}
