package ru.phpprogrammist.music.data.albums


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AlbumsResponse(
    @Json(name = "resultCount")
    val resultCount: Int = 0,
    @Json(name = "results")
    val results: List<Result> = listOf()
)