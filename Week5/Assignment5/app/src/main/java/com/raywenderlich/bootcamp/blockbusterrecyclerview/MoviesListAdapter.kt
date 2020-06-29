package com.raywenderlich.bootcamp.blockbusterrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.raywenderlich.bootcamp.blockbusterrecyclerview.model.Movie

class MoviesListAdapter(private val moviesList: ArrayList<Movie>, val clickListener: MoviesListClickListener): RecyclerView.Adapter<MoviesListItemViewHolder>() {

    interface MoviesListClickListener {
        fun listItemClicked(movie: Movie)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesListItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movies_list_item_viewholder, parent, false)
        return MoviesListItemViewHolder(view)
    }

    override fun getItemCount(): Int = moviesList.size


    override fun onBindViewHolder(holder: MoviesListItemViewHolder, position: Int) {
        val movie = moviesList[position]
        holder.movieImageView.setImageResource(movie.poster)
        holder.movieTitleTextView.text = movie.title
        holder.movieRatingTextView.text = "${movie.rating} / 10"

        holder.itemView.setOnClickListener {
            clickListener.listItemClicked(movie)
        }
    }
}