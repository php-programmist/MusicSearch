package ru.phpprogrammist.music.screens.search

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import android.widget.Toast
import ru.phpprogrammist.music.R
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.coroutines.*

import kotlin.coroutines.CoroutineContext

class SearchActivity : AppCompatActivity(), SearchView.OnQueryTextListener, CoroutineScope {
    override val coroutineContext: CoroutineContext = Dispatchers.Main
    var queryTextChangedJob: Job? = null
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
            if (searchText.length > 2){
                performSearch(searchText)
            }

        }
        return false
    }

    private fun performSearch(query: String){
        Toast.makeText(this,query,Toast.LENGTH_SHORT).show()
        Log.i("search",query)
    }
}
