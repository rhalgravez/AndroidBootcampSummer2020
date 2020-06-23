package com.raywenderlich.bootcamp.blockbusterrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MoviesListAdapter: RecyclerView.Adapter<MoviesListItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesListItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movies_list_item_viewholder, parent, false)
        return MoviesListItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 8
    }

    override fun onBindViewHolder(holder: MoviesListItemViewHolder, position: Int) {
        holder.movieImageView.setImageResource(R.drawable.paddington)
        holder.movieTitleTextView.text = "Paddington".toString()
        holder.movieRatingTextView.text = "15 / 10".toString()
    }
}