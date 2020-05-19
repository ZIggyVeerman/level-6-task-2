package com.example.popularmovieskotlin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.popularmovieskotlin.viewmodels.MainActivityViewModel
import com.example.popularmovieskotlin.adapter.MovieAdapter
import com.example.popularmovieskotlin.model.MovieItem
import com.example.popularmovieskotlin.R
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    private val movies = arrayListOf<MovieItem>()
    private val movieAdapter =
        MovieAdapter(movies) { movieItem ->
            onMovieClick(movieItem)
        }
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        observeViewModel()
    }

    private fun initViews() {
        rvMovies.layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        rvMovies.adapter = movieAdapter

        btSubmit.setOnClickListener { submitButtonClicked() }
    }

    private fun observeViewModel() {
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.movies.observe(this, Observer { movie ->
            movies.clear()
            movies.addAll(movie)
            movieAdapter.notifyDataSetChanged()
        })

    }

    private fun submitButtonClicked() {
        viewModel.getMovies(tilYear.text.toString().toInt())
    }

    private fun onMovieClick(movieItem: MovieItem) {

    }


}
