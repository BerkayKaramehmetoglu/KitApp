package com.example.kitapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kitapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var design: ActivityMainBinding
    private lateinit var adapter: RVAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        design = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)

        val getBooks = GetBooks(this)


        getBooks.searchBooks("ücretsiz", 1)


    }

    fun getDesign(listes: MutableList<items>) {

        design.recyclerView.setHasFixedSize(true) // tasarım üzerine güzelce oturmasını sağlıyor

        design.recyclerView.layoutManager =
            LinearLayoutManager(this@MainActivity) //listenin görünümüyle ilgili yapı

        adapter = RVAdapter(this@MainActivity, listes)

        design.recyclerView.adapter = adapter
    }
}