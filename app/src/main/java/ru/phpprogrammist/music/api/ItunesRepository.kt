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

    fun searchArtists(query: String, limit: Int, offset: Int): ArtistsResponse {
        val entity = "musicArtist"
        return apiService.searchArtists(query, entity, limit, offset).execute().body()?:ArtistsResponse()
    }

    fun getAlbums(amgArtistId: Int, limit: Int, offset: Int): MutableLiveData<AlbumsResponse> {
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
                    Log.e("music_tag", "Error during ItunesRepository:getAlbums: {${t.message}}")
                }
            })
        return liveData
    }

    fun getSongs(amgArtistId: Int, limit: Int, offset: Int): MutableLiveData<SongsResponse> {
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
                    Log.e("music_tag", "Error during ItunesRepository:getSongs: {${t.message}}")
                }
            })
        return liveData
    }
}