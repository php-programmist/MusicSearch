package ru.phpprogrammist.music.screens.details

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import ru.phpprogrammist.music.data.albums.Album
import ru.phpprogrammist.music.data.songs.Song
import java.util.concurrent.Executors

class DetailsViewModel(application: Application) : AndroidViewModel(application) {
    private var albumsLiveData: LiveData<PagedList<Album>>? = null
    private var songsLiveData: LiveData<PagedList<Song>>? = null
    private val albumsSourceFactory = AlbumsSourceFactory()
    private val songsSourceFactory = SongsSourceFactory()
    private val listsConfig = PagedList.Config.Builder()
        .setPageSize(PAGED_LIST_PAGE_SIZE)
        .setInitialLoadSizeHint(PAGED_LIST_PAGE_SIZE)
        .setPrefetchDistance(PREFETCH_DISTANCE)
        .setEnablePlaceholders(PAGED_LIST_ENABLE_PLACEHOLDERS)
        .build()

    val allAlbums: LiveData<PagedList<Album>>
        get() {
            if (null == albumsLiveData) {
                val builder = LivePagedListBuilder<Int, Album>(albumsSourceFactory, listsConfig)
                albumsLiveData = builder.setFetchExecutor(Executors.newSingleThreadExecutor())
                    .build()
            }
            return albumsLiveData ?: throw AssertionError("Check your threads ...")
        }

    val allSongs: LiveData<PagedList<Song>>
        get() {
            if (null == songsLiveData) {
                val builder = LivePagedListBuilder<Int, Song>(songsSourceFactory, listsConfig)
                songsLiveData = builder.setFetchExecutor(Executors.newSingleThreadExecutor())
                    .build()
            }
            return songsLiveData ?: throw AssertionError("Check your threads ...")
        }

    fun setId(artistId: Int) {
        albumsSourceFactory.artistId = artistId
        songsSourceFactory.artistId = artistId
        albumsLiveData=null
        songsLiveData=null
    }

    companion object {
        private const val PAGED_LIST_PAGE_SIZE = 10
        private const val PREFETCH_DISTANCE = 3
        private const val PAGED_LIST_ENABLE_PLACEHOLDERS = false
    }
}