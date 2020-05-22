package com.example.popularmovieskotlin.model

import com.google.gson.annotations.SerializedName

data class ResultSetWithMovies (
    @SerializedName("results") var movies: ArrayList<MovieItem>
    )