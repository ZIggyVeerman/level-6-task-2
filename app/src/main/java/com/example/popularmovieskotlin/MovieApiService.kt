package com.example.popularmovieskotlin

import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {
    @GET("/discover/movie")
    suspend fun getMovies(
        @Query("api_key") api_key: String,
        @Query("year") year: Int
    ):
            MovieItem
}