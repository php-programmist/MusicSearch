package ru.phpprogrammist.music.screens.search

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import ru.phpprogrammist.music.data.artists.Artist
import java.util.concurrent.Executors

class SearchViewModel(application: Application) : AndroidViewModel(application){
    private var artistsLiveData: LiveData<PagedList<Artist>>? = null
    private val artistsSourceFactory = ArtistsSourceFactory()
    val allArtists: LiveData<PagedList<Artist>>
        get() {
            if (null == artistsLiveData) {
                val config = PagedList.Config.Builder()
                    .setPageSize(PAGED_LIST_PAGE_SIZE)
                    .setInitialLoadSizeHint(PAGED_LIST_PAGE_SIZE)
                    .setPrefetchDistance(PREFETCH_DISTANCE)
                    .setEnablePlaceholders(PAGED_LIST_ENABLE_PLACEHOLDERS)
                    .build()

                val builder = LivePagedListBuilder<Int,Artist>(artistsSourceFactory,config)
                artistsLiveData = builder.setFetchExecutor(Executors.newSingleThreadExecutor())
                    .build()

            }
            return artistsLiveData ?: throw AssertionError("Check your threads ...")
        }

    fun setQuery(query: String){
        artistsSourceFactory.query = query
        artistsLiveData = null // invalidate
    }
    companion object {
        private const val PAGED_LIST_PAGE_SIZE = 50
        private const val PREFETCH_DISTANCE = 10
        private const val PAGED_LIST_ENABLE_PLACEHOLDERS = false
    }
}