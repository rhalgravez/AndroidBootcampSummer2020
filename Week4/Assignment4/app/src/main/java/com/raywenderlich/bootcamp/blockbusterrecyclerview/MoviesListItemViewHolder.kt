package com.raywenderlich.bootcamp.blockbusterrecyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.movies_list_item_viewholder.view.*

class MoviesListItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val movieImageView = itemView.movie_image_view
    val movieTitleTextView = itemView.title_movie_text_view
    val movieRatingTextView = itemView.rating_movie_text_view
}