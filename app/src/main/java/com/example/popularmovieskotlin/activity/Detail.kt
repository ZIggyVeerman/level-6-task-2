package com.example.popularmovieskotlin.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.popularmovieskotlin.R
import com.example.popularmovieskotlin.adapter.MovieAdapter
import com.example.popularmovieskotlin.api.MovieApi
import com.example.popularmovieskotlin.model.MovieItem
import kotlinx.android.synthetic.main.activity_detail.*

class Detail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = ""
        initViews()

    }

    private fun initViews() {
        val movieItem = intent.getParcelableExtra<MovieItem>("EXTRA")
        Glide.with(this).load(MovieApi.imageUrl + movieItem?.backdrop).into(ivBackdrop)
        Glide.with(this).load(MovieApi.imageUrl + movieItem?.poster).into(ivPoster)
        tvTitle.text = movieItem?.title
        tvReleaseDate.text = movieItem?.releaseDate
        tvStarText.text = movieItem?.voteAverage.toString()
        tvOverviewFromDB.text = movieItem?.overview

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return try {
            finish()
            true
        } catch (e: Exception) {
            false
        }
    }


}
