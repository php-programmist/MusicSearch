package ru.phpprogrammist.music.data.albums


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Result(
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
    @Json(name = "artistViewUrl")
    val artistViewUrl: String = "",
    @Json(name = "artworkUrl100")
    val artworkUrl100: String = "",
    @Json(name = "artworkUrl60")
    val artworkUrl60: String = "",
    @Json(name = "collectionCensoredName")
    val collectionCensoredName: String = "",
    @Json(name = "collectionExplicitness")
    val collectionExplicitness: String = "",
    @Json(name = "collectionId")
    val collectionId: Int = 0,
    @Json(name = "collectionName")
    val collectionName: String = "",
    @Json(name = "collectionPrice")
    val collectionPrice: Double = 0.0,
    @Json(name = "collectionType")
    val collectionType: String = "",
    @Json(name = "collectionViewUrl")
    val collectionViewUrl: String = "",
    @Json(name = "contentAdvisoryRating")
    val contentAdvisoryRating: String = "",
    @Json(name = "copyright")
    val copyright: String = "",
    @Json(name = "country")
    val country: String = "",
    @Json(name = "currency")
    val currency: String = "",
    @Json(name = "primaryGenreId")
    val primaryGenreId: Int = 0,
    @Json(name = "primaryGenreName")
    val primaryGenreName: String = "",
    @Json(name = "releaseDate")
    val releaseDate: String = "",
    @Json(name = "trackCount")
    val trackCount: Int = 0,
    @Json(name = "wrapperType")
    val wrapperType: String = ""
)