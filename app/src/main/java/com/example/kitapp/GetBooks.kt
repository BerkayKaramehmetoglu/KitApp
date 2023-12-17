package com.example.kitapp

import android.util.Log
import com.example.kitapp.retrofit.imageLinks
import com.example.kitapp.MainActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class GetBooks(private val instance: MainActivity) {

    private val rft = ApiUtils.getIBooksDao()
    private var startIndex = 0
    private var _listes: MutableList<items> = mutableListOf()
    private var _page: Int = 1
    val listes: MutableList<items>
        get() {
            return _listes
        }
    companion object {
        private const val MAX_RESULTS = 40
        private const val VIEW_ABILITY: String = "ALL_PAGES"
    }

    fun searchBooks(query: String, page: Int) {
        this._page = page
        rft.searchBooks(query, MAX_RESULTS, startIndex).enqueue(object : Callback<Books> {
            override fun onFailure(call: Call<Books>, t: Throwable) {
                Log.e("Veri Gelirken Hata Oluştu", t.toString())
            }

            override fun onResponse(call: Call<Books>, response: Response<Books>) {
                val items = response.body()
                for (item in items?.items!!) {
                    if (item.accessInfo.viewability == VIEW_ABILITY && item.accessInfo.pdf.isAvailable && item.saleInfo.isEbook) {
                        _listes.add(item)
                    }
                }

                if ((startIndex + MAX_RESULTS) >= items.totalItems) {
                    return
                }

                if (_page * MAX_RESULTS <= listes.count()) {
                    instance.getDesign(listes)
                    //updateList()
                    return
                }

                startIndex += MAX_RESULTS
                searchBooks(query, _page)
            }
        })

    }
}

