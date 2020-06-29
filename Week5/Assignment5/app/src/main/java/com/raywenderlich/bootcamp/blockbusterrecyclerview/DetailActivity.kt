package com.raywenderlich.bootcamp.blockbusterrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.raywenderlich.bootcamp.blockbusterrecyclerview.model.Movie
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    lateinit var movie: Movie

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        movie = intent.getParcelableExtra(MainFragment.INTENT_MOVIE_KEY) as Movie

        movie_imageView.setImageResource(movie.poster)
        title_textView.text = movie.title
        releaseDate_textView.text = movie.releaseDate
        rating_textView.text = "${movie.rating} / 10"
        summary_textView.text = movie.summary
    }
}