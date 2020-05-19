package com.example.popularmovieskotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.popularmovieskotlin.api.MovieApi
import com.example.popularmovieskotlin.R
import com.example.popularmovieskotlin.model.MovieItem
import kotlinx.android.synthetic.main.item.view.*

class MovieAdapter(private val movies: List<MovieItem>, private val Onclick: ((MovieItem) -> Unit)) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context

        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item, parent, false)
        )
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(movies[position])


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener { Onclick(movies[adapterPosition]) }
        }

        fun bind(movieItem: MovieItem) {
//            itemView.tvMovieTitle.text =
//                context.getString(R.string.title, "${adapterPosition}_")
            Glide.with(context).load(MovieApi.imageUrl + movieItem.poster).into(itemView.ivMovie)
        }
    }
}