package com.example.popularmovieskotlin

import com.google.gson.annotations.SerializedName

data class MovieItem(
    @SerializedName("title") var title: String,
    @SerializedName("poster_path") var poster: String,
    @SerializedName("overview") var overview: String,
    @SerializedName("release_date") var releaseDate: String,
    @SerializedName("vote_average") var voteAverage: Double,
    @SerializedName("backdrop_path") var backdrop: String
)
