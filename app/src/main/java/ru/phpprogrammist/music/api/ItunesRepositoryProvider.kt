package ru.phpprogrammist.music.api

object ItunesRepositoryProvider {
    fun provideItunesRepository(): ItunesRepository {
        val apiService = ApiService.create()
        return ItunesRepository(apiService)
    }
}