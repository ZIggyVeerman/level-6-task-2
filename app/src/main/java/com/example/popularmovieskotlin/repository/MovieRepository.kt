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

    private val _movie: MutableLiveData<ArrayList<MovieItem>> = MutableLiveData()

    val movie: LiveData<ArrayList<MovieItem>>
        get() = _movie

    suspend fun getMovie(year: Int) {

        try {
            val result = movieApi.getMovies(key, year)

            _movie.value = result.movies

        } catch (error: Throwable) {
            throw MovieRefreshError(
                "Unable to fetch movie", error
            )
        }
    }

    class MovieRefreshError(message: String, cause: Throwable) : Throwable(message, cause)
}