package ru.phpprogrammist.music.api

import ru.phpprogrammist.music.data.albums.AlbumsResponse
import ru.phpprogrammist.music.data.artists.ArtistsResponse
import ru.phpprogrammist.music.data.songs.SongsResponse

class ItunesRepository(private val apiService: ApiService) {

    fun searchArtists(query: String, limit: Int, offset: Int): ArtistsResponse {
        val entity = "musicArtist"
        return apiService.searchArtists(query, entity, limit, offset).execute().body()?:ArtistsResponse()
    }

    fun getAlbums(artistId: Int, limit: Int, offset: Int): AlbumsResponse {
        val entity = "album"
        return apiService.getAlbums(artistId, entity, limit, offset).execute().body()?:AlbumsResponse()

    }

    fun getSongs(artistId: Int, limit: Int, offset: Int): SongsResponse {
        val entity = "song"
        return apiService.getSongs(artistId, entity, limit, offset).execute().body()?:SongsResponse()
    }
}