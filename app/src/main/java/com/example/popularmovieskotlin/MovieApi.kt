package com.example.popularmovieskotlin

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieApi {
    companion object {
        private const val baseUrl = "https://api.themoviedb.org/3/"
        const val imageUrl = "https://image.tmdb.org/t/p/w500/"

        fun createApi(): MovieApiService {
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()

            val moviesApi = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return moviesApi.create(MovieApiService::class.java)
        }
    }
}