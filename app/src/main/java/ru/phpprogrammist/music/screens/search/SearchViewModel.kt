package ru.phpprogrammist.music.screens.search

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import ru.phpprogrammist.music.api.ItunesRepositoryProvider
import ru.phpprogrammist.music.data.artists.ArtistsResponse

class SearchViewModel(application: Application) : AndroidViewModel(application){
    fun searchArtists(query: String, limit: Long = 50, offset: Long = 0): MutableLiveData<ArtistsResponse> {
        val repository = ItunesRepositoryProvider.provideItunesRepository()
        return repository.searchArtists(query,limit,offset)
    }
}