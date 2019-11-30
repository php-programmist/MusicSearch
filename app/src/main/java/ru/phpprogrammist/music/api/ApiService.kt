package ru.phpprogrammist.music.api

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import ru.phpprogrammist.music.data.albums.AlbumsResponse
import ru.phpprogrammist.music.data.artists.ArtistsResponse
import ru.phpprogrammist.music.data.songs.SongsResponse

interface ApiService {
    @GET("search")
    fun searchArtists(
        @Query("term") query: String,
        @Query("entity") entity: String,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Call<ArtistsResponse>

    @GET("lookup")
    fun getAlbums(
        @Query("id") artistId: Int,
        @Query("entity") entity: String,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Call<AlbumsResponse>

    @GET("lookup")
    fun getSongs(
        @Query("id") artistId: Int,
        @Query("entity") entity: String,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Call<SongsResponse>

    companion object Factory {
        private const val BASE_URL = "https://itunes.apple.com/"
        fun create(): ApiService {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(MoshiConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()

            return retrofit.create(ApiService::class.java)
        }
    }
}