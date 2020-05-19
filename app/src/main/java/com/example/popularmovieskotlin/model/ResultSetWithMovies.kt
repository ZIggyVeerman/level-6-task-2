package com.example.popularmovieskotlin.model

import com.google.gson.annotations.SerializedName

data class ResultSetWithMovies (
    @SerializedName("results") var movies: Array<MovieItem>
    ) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ResultSetWithMovies

        if (!movies.contentEquals(other.movies)) return false

        return true
    }

    override fun hashCode(): Int {
        return movies.contentHashCode()
    }
}