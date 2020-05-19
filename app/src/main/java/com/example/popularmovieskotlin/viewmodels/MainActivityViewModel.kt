package com.example.popularmovieskotlin.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.popularmovieskotlin.model.MovieItem
import com.example.popularmovieskotlin.repository.MovieRepository
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {

    private val movieRepository = MovieRepository()

    val movies = movieRepository.movie

    private val _errorText: MutableLiveData<String> = MutableLiveData()

    val errorText: LiveData<String>
        get() = _errorText

    fun getMovies(year: Int) {
        viewModelScope.launch {
            try {
                movieRepository.getMovie(year)

            } catch (error: MovieRepository.MovieRefreshError) {
                _errorText.value = error.message
            }
        }
    }
}