package com.example.kitapp

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class GetBooks() {

    private val rft = ApiUtils.getIBooksDao()
    private val VIEWABILITY: String = "ALL_PAGES"

    fun searchBooks(query: String, startIndex: Int = 0) {
        val MAX_RESULTS = 40
        val start_index = startIndex


        Log.e("Start Index", startIndex.toString())
        rft.searchBooks(query, MAX_RESULTS, start_index).enqueue(object : Callback<Books> {
            override fun onFailure(call: Call<Books>, t: Throwable) {
                Log.e("Veri Gelirken Hata Oluştu", t.toString())
            }

            override fun onResponse(call: Call<Books>, response: Response<Books>) {
                val items = response.body()
                for (item in items?.items!!) {
                    if (item.accessInfo.viewability == VIEWABILITY && item.accessInfo.pdf.isAvailable && item.saleInfo.isEbook) {
                        Log.e("Okuna Bilir", item.toString())

                    }
                }
                if ((start_index + 1) * MAX_RESULTS >= items.totalItems) {
                    Log.e("Başarılı", "bitti")
                    return
                }
                Log.e("Başarılı", items.totalItems.toString())

                searchBooks(query, start_index + MAX_RESULTS)
            }
        })

    }

}

