package com.example.kitapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class RVAdapter(
    private val mContext: Context,
    private var listes: List<items> = mutableListOf()
) : RecyclerView.Adapter<RVAdapter.CardDesign>() {
    inner class CardDesign(view: View) : RecyclerView.ViewHolder(view) {

        var cardId: CardView
        var cardText: TextView
        var cardImage: ImageView

        init {
            cardId = view.findViewById(R.id.cardId)
            cardText = view.findViewById(R.id.cardText)
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

        Picasso.get().load(listes.volumeInfo.imageLinks?.smallThumbnail).into(holder.cardImage)
        holder.cardText.text = listes.volumeInfo.title

        holder.cardId.setOnClickListener {
            Toast.makeText(mContext, "Karta Tıklama İşlemi Tamam", Toast.LENGTH_LONG).show()
        }
    }

}