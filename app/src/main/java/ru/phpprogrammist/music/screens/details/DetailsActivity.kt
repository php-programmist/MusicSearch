package ru.phpprogrammist.music.screens.details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_details.*
import ru.phpprogrammist.music.R
import ru.phpprogrammist.music.adapters.AlbumsPagedListAdapter


class DetailsActivity : AppCompatActivity() {

    private val viewModel by lazy { ViewModelProviders.of(this).get(DetailsViewModel::class.java) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val artistName = intent.getStringExtra("artistName")
        val artistId = intent.getIntExtra("artistId",0)
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.title = artistName
        viewModel.setId(artistId)
        initAlbumsList()
    }
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    private fun initAlbumsList() {
        val adapter = AlbumsPagedListAdapter()
        albumsList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        albumsList.adapter = adapter
        viewModel.allAlbums.observe(this, Observer { pagedList ->
            adapter.submitList(pagedList)
        })
    }
}
