package ru.phpprogrammist.music.data.artists


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ArtistsResponse(
    @Json(name = "resultCount")
    val resultCount: Int = 0,
    @Json(name = "results")
    val results: List<Result> = listOf()
)