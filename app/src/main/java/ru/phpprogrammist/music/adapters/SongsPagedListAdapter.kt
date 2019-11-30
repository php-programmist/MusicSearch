package ru.phpprogrammist.music.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.song_item.view.*
import ru.phpprogrammist.music.R
import ru.phpprogrammist.music.data.songs.Song

class SongsPagedListAdapter : PagedListAdapter<Song, SongsPagedListAdapter.ViewHolder>(
    diffCallback
) {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.song_item, parent, false)
        return ViewHolder(v)
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<Song>() {
            override fun areItemsTheSame(oldItem: Song, newItem: Song): Boolean = oldItem.trackId == newItem.trackId
            override fun areContentsTheSame(oldItem: Song, newItem: Song): Boolean = oldItem.trackName == newItem.trackName
        }
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Song?) = with(itemView) {
            trackName.text = item?.trackName?:"Error"
            artistName.text = item?.artistName?:"Error"
        }
    }
}