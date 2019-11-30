package ru.phpprogrammist.music.screens.search

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import ru.phpprogrammist.music.R
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.coroutines.*
import ru.phpprogrammist.music.adapters.ArtistsPagedListAdapter

import kotlin.coroutines.CoroutineContext

class SearchActivity : AppCompatActivity(), SearchView.OnQueryTextListener, CoroutineScope {
    override val coroutineContext: CoroutineContext = Dispatchers.Main
    var queryTextChangedJob: Job? = null
    private val viewModel by lazy { ViewModelProviders.of(this).get(SearchViewModel::class.java) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        artistSearch.setOnQueryTextListener(this)
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        return false
    }

    override fun onQueryTextChange(newText: String): Boolean {
        val searchText = newText.trim()
        queryTextChangedJob?.cancel()
        queryTextChangedJob = launch(Dispatchers.Main) {
            delay(1000)
            if (searchText.length > 2 || searchText.isEmpty()){
                performSearch(searchText)
            }

        }
        return false
    }

    private fun performSearch(query: String){
        Log.i("music_tag",query)
        viewModel.setQuery(query)
        initList()
    }

    private fun initList() {
        val adapter = ArtistsPagedListAdapter {
            Toast.makeText(this, "${it?.artistName} Clicked", Toast.LENGTH_SHORT).show()
        }
        artistsList.layoutManager = LinearLayoutManager(this)
        artistsList.adapter = adapter
        viewModel.allArtists.observe(this, Observer { pagedList ->
            adapter.submitList(pagedList)
        })
    }
}
