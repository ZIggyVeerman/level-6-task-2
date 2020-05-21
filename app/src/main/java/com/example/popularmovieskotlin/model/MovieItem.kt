package com.example.popularmovieskotlin.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieItem(
    @SerializedName("title") var title: String,
    @SerializedName("poster_path") var poster: String,
    @SerializedName("overview") var overview: String,
    @SerializedName("release_date") var releaseDate: String,
    @SerializedName("vote_average") var voteAverage: Double,
    @SerializedName("backdrop_path") var backdrop: String
) : Parcelable