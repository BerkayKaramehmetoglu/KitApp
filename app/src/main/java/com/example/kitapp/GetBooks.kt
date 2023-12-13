package com.example.kitapp

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class GetBooks() {

    private val rft = ApiUtils.getIBooksDao()
    private var startIndex = 0
    private var _listes: MutableList<String> = mutableListOf<String>()
    val listes: MutableList<String>
        get() {
            return _listes
        }

    companion object {
        private const val MAX_RESULTS = 40
        private const val VIEW_ABILITY: String = "ALL_PAGES"
    }

    fun searchBooks(query: String, page: Int = 1) {
        rft.searchBooks(query, MAX_RESULTS, startIndex).enqueue(object : Callback<Books> {
            override fun onFailure(call: Call<Books>, t: Throwable) {
                Log.e("Veri Gelirken Hata Oluştu", t.toString())
            }

            override fun onResponse(call: Call<Books>, response: Response<Books>) {
                val items = response.body()
                for (item in items?.items!!) {
                    if (item.accessInfo.viewability == VIEW_ABILITY && item.accessInfo.pdf.isAvailable && item.saleInfo.isEbook) {
                        _listes.add(item.toString())
                    }
                }

                if ((startIndex + MAX_RESULTS) >= items.totalItems) {
                    return
                }

                if (page * MAX_RESULTS <= _listes.count()) {
                    updateList()
                    return
                }
                startIndex += MAX_RESULTS
                searchBooks(query)
            }
        })

    }

    private fun updateList() {
        val listem: MutableList<String> = listes
        Log.e("aa",listem.toString())
    }
}

