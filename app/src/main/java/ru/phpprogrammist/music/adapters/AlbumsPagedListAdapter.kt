package ru.phpprogrammist.music.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.album_item.view.*
import ru.phpprogrammist.music.R
import ru.phpprogrammist.music.data.albums.Album

class AlbumsPagedListAdapter : PagedListAdapter<Album, AlbumsPagedListAdapter.ViewHolder>(
    diffCallback
) {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.album_item, parent, false)
        return ViewHolder(v)
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<Album>() {
            override fun areItemsTheSame(oldItem: Album, newItem: Album): Boolean = oldItem.collectionId == newItem.collectionId
            override fun areContentsTheSame(oldItem: Album, newItem: Album): Boolean = oldItem.collectionName == newItem.collectionName
        }
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Album?) = with(itemView) {
            collectionName.text = item?.collectionName?:"Error"
        }
    }
}