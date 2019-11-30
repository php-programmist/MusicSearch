package ru.phpprogrammist.music.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.artist_item.view.*
import ru.phpprogrammist.music.R
import ru.phpprogrammist.music.data.artists.Artist

class ArtistsAdapter(val items: List<Artist>, val listener: (Artist) -> Unit) : RecyclerView.Adapter<ArtistsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.artist_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position], listener)

    override fun getItemCount()= items.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Artist, listener: (Artist) -> Unit) = with(itemView) {
            artistName.text = item.artistName
            setOnClickListener { listener(item) }
        }
    }
}