package com.example.kitapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.max


class MainActivity : AppCompatActivity() {
    private val rft = ApiUtils.getIBooksDao()
    private val MAX_RESULTS = 40
    private var startedIndex = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchBooksTitle("Nutuk")
        //getCategory("History")
    }

    public fun nextPage(query: String) {
        startedIndex += 1;
        searchBooksTitle(query, startedIndex)
    }

    //Call With Books Title Parameter
    private fun searchBooksTitle(query: String, startIndex: Int = 0) {
        //var startIndex = startIndex

        rft.searchBooksTitle(query, MAX_RESULTS, startIndex).enqueue(object : Callback<Books> {
            override fun onFailure(call: Call<Books>, t: Throwable) {
                Log.e("Basarısız", t.toString())
            }

            override fun onResponse(call: Call<Books>, response: Response<Books>) {
                val items = response.body()
                //Log.e("Başarılı", "sayfa: "+(startIndex+1))
                for (item in items!!.items) {
                    if (item.volumeInfo.title == query) {
                        Log.e("İstenen Kategori", item.volumeInfo.title)
                    } else {
                        Log.e("İstenen Kategori Değil", item.volumeInfo.title)
                    }
                }
                /*if (items.totalItems <= (++startIndex + 1) * MAX_RESULTS) {
                    Log.e("Başarılı", "bitti")
                    return
                }
                Log.e("Başarılı", items.totalItems.toString())

                searchBooksTitle(query, startIndex)*/
            }
        })
    }

    //Call With Books Category Parameter
    private fun getCategory(query: String) {
        rft.getCategory(query).enqueue(object : Callback<Books> {

            override fun onFailure(call: Call<Books>, t: Throwable) {
                Log.e("Basarısız", t.toString())
            }

            override fun onResponse(call: Call<Books>, response: Response<Books>) {
                for (element in response.body()?.items!!) {
                    if (element.volumeInfo.categories[0] == query) {
                        Log.e("İstenen Kategori", element.volumeInfo.categories.toString())
                    } else {
                        Log.e("İstenmeyen Kategori", element.volumeInfo.categories.toString())
                    }
                }
            }
        })
    }

}
