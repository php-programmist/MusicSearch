package ru.phpprogrammist.music.data.songs


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SongsResponse(
    @Json(name = "resultCount")
    val resultCount: Int = 0,
    @Json(name = "results")
    val results: List<Result> = listOf()
)