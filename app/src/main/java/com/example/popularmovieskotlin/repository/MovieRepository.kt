package com.example.popularmovieskotlin.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.popularmovieskotlin.BuildConfig
import com.example.popularmovieskotlin.api.MovieApi
import com.example.popularmovieskotlin.api.MovieApiService
import com.example.popularmovieskotlin.model.MovieItem

const val key: String = BuildConfig.API_KEY

class MovieRepository {
    private val movieApi: MovieApiService = MovieApi.createApi()

    private val _movie: MutableLiveData<MovieItem> = MutableLiveData()

    val movie: LiveData<MovieItem>
        get() = _movie

    suspend fun getMovie(year: Int) {
        try {
            val result = movieApi.getMovies(key, year)

            result.movies.forEach {
                _movie.postValue(it)
            }

        } catch (error: Throwable) {
            throw MovieRefreshError(
                "Unable to fetch movie",
                error
            )
        }
    }

    class MovieRefreshError(message: String, cause: Throwable) : Throwable(message, cause)
}