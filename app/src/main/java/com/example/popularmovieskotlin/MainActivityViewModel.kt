package com.example.popularmovieskotlin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.lang.Error

class MainActivityViewModel : ViewModel() {

    private val movieRepository = MovieRepository()

    //val movie =

    private val _errorText: MutableLiveData<String> = MutableLiveData()

    val errorText: LiveData<String>
        get() = _errorText

    fun getMovies(year: Number) {
        try {
            //TODO: Dingen en spullen
        } catch (error: Error) {
            _errorText.value = error.message
        }

    }


}