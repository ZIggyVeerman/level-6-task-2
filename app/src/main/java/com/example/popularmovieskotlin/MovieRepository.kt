package com.example.popularmovieskotlin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.withTimeout

const val key: String = BuildConfig.API_KEY

class MovieRepository {
    private val movieApi: MovieApiService = MovieApi.createApi()

    private val _movie: MutableLiveData<MovieItem> = MutableLiveData()

    val movie: LiveData<MovieItem>
        get() = _movie

    suspend fun getMovie(year: Int) {
        try {
            val result = movieApi.getMovies(key, year)

            _movie.value = result
        } catch (error: Throwable) {
            throw MovieRefreshError("Unable to fetch movie", error)
        }
    }

    class MovieRefreshError(message: String, cause: Throwable) : Throwable(message, cause)
}