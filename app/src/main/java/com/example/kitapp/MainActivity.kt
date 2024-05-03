package com.example.kitapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.ViewGroup
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.kitapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnQueryTextListener{
    private lateinit var design: ActivityMainBinding
    private lateinit var adapter: RVAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        design = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)

        val getBooks = GetBooks(this)
        design.toolbar.title = "Ücretsiz KitAPP'lar"
        setSupportActionBar(design.toolbar)
        getBooks.searchBooks("ücretsiz", 1)


    }

    fun getDesign(listes: MutableList<items>) {

        design.recyclerView.setHasFixedSize(true) // tasarım üzerine güzelce oturmasını sağlıyor

        design.recyclerView.layoutManager =
            StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL)

        adapter = RVAdapter(this@MainActivity, listes)

        design.recyclerView.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)

        val item = menu?.findItem(R.id.action_search)
        val searchView = item?.actionView as androidx.appcompat.widget.SearchView
        searchView.setOnQueryTextListener(this)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onQueryTextSubmit(p0: String?): Boolean {
        Log.e("Her arama yapıldığında", p0!!)
        return true
    }

    override fun onQueryTextChange(p0: String?): Boolean {
        Log.e("Her harf değiştiğinde", p0!!)
        return true
    }
}