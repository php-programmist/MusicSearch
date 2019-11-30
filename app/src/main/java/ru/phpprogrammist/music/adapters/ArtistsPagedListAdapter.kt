package ru.phpprogrammist.music.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.artist_item.view.*
import ru.phpprogrammist.music.R
import ru.phpprogrammist.music.data.artists.Result
class ArtistsPagedListAdapter(private val listener: (Result?) -> Unit) : PagedListAdapter<Result, ArtistsPagedListAdapter.ViewHolder>(
    diffCallback
) {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position),listener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.artist_item, parent, false)
        return ViewHolder(
            v
        )
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<Result>() {
            override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean = oldItem.artistId == newItem.artistId
            override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean = oldItem.artistName == newItem.artistName
        }
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Result?, listener: (Result?) -> Unit) = with(itemView) {
            artistName.text = item?.artistName?:"Error"
            setOnClickListener { listener(item) }
        }
    }
}