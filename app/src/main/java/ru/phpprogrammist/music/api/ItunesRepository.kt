package ru.phpprogrammist.music.api

import android.util.Log
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.phpprogrammist.music.data.albums.AlbumsResponse
import ru.phpprogrammist.music.data.artists.ArtistsResponse
import ru.phpprogrammist.music.data.songs.SongsResponse

class ItunesRepository(private val apiService: ApiService) {

    fun searchArtists(query: String, limit: Long, offset: Long): MutableLiveData<ArtistsResponse> {
        val liveData: MutableLiveData<ArtistsResponse> = MutableLiveData()
        val entity = "musicArtist"
        apiService.searchArtists(query, entity, limit, offset)
            .enqueue(object : Callback<ArtistsResponse> {
                override fun onResponse(
                    call: Call<ArtistsResponse>,
                    response: Response<ArtistsResponse>
                ) {
                    if (response.isSuccessful) {
                        liveData.value = response.body()
                    }
                }

                override fun onFailure(
                    call: Call<ArtistsResponse>,
                    t: Throwable
                ) {
                    Log.e("music", "Error during ItunesRepository:searchArtists: {${t.message}}")
                }
            })
        return liveData
    }

    fun getAlbums(amgArtistId: Long, limit: Long, offset: Long): MutableLiveData<AlbumsResponse> {
        val liveData: MutableLiveData<AlbumsResponse> = MutableLiveData()
        val entity = "album"
        apiService.getAlbums(amgArtistId, entity, limit, offset)
            .enqueue(object : Callback<AlbumsResponse> {
                override fun onResponse(
                    call: Call<AlbumsResponse>,
                    response: Response<AlbumsResponse>
                ) {
                    if (response.isSuccessful) {
                        liveData.value = response.body()
                    }
                }

                override fun onFailure(
                    call: Call<AlbumsResponse>,
                    t: Throwable
                ) {
                    Log.e("music", "Error during ItunesRepository:getAlbums: {${t.message}}")
                }
            })
        return liveData
    }

    fun getSongs(amgArtistId: Long, limit: Long, offset: Long): MutableLiveData<SongsResponse> {
        val liveData: MutableLiveData<SongsResponse> = MutableLiveData()
        val entity = "song"
        apiService.getSongs(amgArtistId, entity, limit, offset)
            .enqueue(object : Callback<SongsResponse> {
                override fun onResponse(
                    call: Call<SongsResponse>,
                    response: Response<SongsResponse>
                ) {
                    if (response.isSuccessful) {
                        liveData.value = response.body()
                    }
                }

                override fun onFailure(
                    call: Call<SongsResponse>,
                    t: Throwable
                ) {
                    Log.e("music", "Error during ItunesRepository:getSongs: {${t.message}}")
                }
            })
        return liveData
    }
}