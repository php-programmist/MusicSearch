package ru.phpprogrammist.music.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.artist_item.view.*
import ru.phpprogrammist.music.R
import ru.phpprogrammist.music.data.artists.Artist
class ArtistsPagedListAdapter(private val listener: (Artist?) -> Unit) : PagedListAdapter<Artist, ArtistsPagedListAdapter.ViewHolder>(
    diffCallback
) {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position),listener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.artist_item, parent, false)
        return ViewHolder(v)
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<Artist>() {
            override fun areItemsTheSame(oldItem: Artist, newItem: Artist): Boolean = oldItem.artistId == newItem.artistId
            override fun areContentsTheSame(oldItem: Artist, newItem: Artist): Boolean = oldItem.artistName == newItem.artistName
        }
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Artist?, listener: (Artist?) -> Unit) = with(itemView) {
            artistName.text = item?.artistName?:"Error"
            setOnClickListener { listener(item) }
        }
    }
}