package ru.phpprogrammist.music.data.artists


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Artist(
    @Json(name = "amgArtistId")
    val amgArtistId: Int = 0,
    @Json(name = "artistId")
    val artistId: Int = 0,
    @Json(name = "artistLinkUrl")
    val artistLinkUrl: String = "",
    @Json(name = "artistName")
    val artistName: String = "",
    @Json(name = "artistType")
    val artistType: String = "",
    @Json(name = "primaryGenreId")
    val primaryGenreId: Int = 0,
    @Json(name = "primaryGenreName")
    val primaryGenreName: String = "",
    @Json(name = "wrapperType")
    val wrapperType: String = ""
)