package com.example.kitapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.ViewAnimator
import androidx.appcompat.app.AlertDialog
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.kitapp.retrofit.volumeInfo
import com.squareup.picasso.Picasso

class RVAdapter(
    private val mContext: Context,
    private var listes: List<items> = mutableListOf()
) : RecyclerView.Adapter<RVAdapter.CardDesign>() {
    inner class CardDesign(view: View) : RecyclerView.ViewHolder(view) {

        var card: CardView
        var cardImage: ImageView

        init {
            card = view.findViewById(R.id.card)
            cardImage = view.findViewById(R.id.cardImage)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesign {

        val design = LayoutInflater.from(mContext).inflate(R.layout.card_design, parent, false)

        return CardDesign(design)
    }

    override fun getItemCount(): Int {
        return listes.size
    }

    override fun onBindViewHolder(holder: CardDesign, position: Int) {
        val listes = listes[position]

        val tasarim = LayoutInflater.from(mContext).inflate(R.layout.custom_popup, null)
        val builder = AlertDialog.Builder(mContext)
        builder.setView(tasarim)
        val image = tasarim.findViewById<ImageView>(R.id.popupImage)
        val title = tasarim.findViewById<TextView>(R.id.popupTitle)
        val desc = tasarim.findViewById<TextView>(R.id.popupDesc)
        val pageCount = tasarim.findViewById<TextView>(R.id.popupPage)
        val language = tasarim.findViewById<TextView>(R.id.popupLanguage)
        val authors = tasarim.findViewById<TextView>(R.id.popupAuthors)
        val categories = tasarim.findViewById<TextView>(R.id.popupCategory)
        val dialog = builder.create()

        Picasso.get()
            .load(listes.volumeInfo.imageLinks?.extraLarge)
            .resize(500, 500)
            .into(holder.cardImage)

        holder.card.setOnClickListener {
            Picasso.get()
                .load(listes.volumeInfo.imageLinks?.extraLarge)
                .resize(500, 500)
                .into(image)
            title.text = listes.volumeInfo.title
            desc.text = listes.volumeInfo.description
            pageCount.text = listes.volumeInfo.pageCount.toString()
            language.text = listes.volumeInfo.language
            categories.text = listes.volumeInfo.categories?.joinToString(", ")
            authors.text = listes.volumeInfo.authors?.joinToString(", ")
            dialog.show()

        }
    }

}