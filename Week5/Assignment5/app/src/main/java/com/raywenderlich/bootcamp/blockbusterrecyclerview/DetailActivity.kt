package com.raywenderlich.bootcamp.blockbusterrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.raywenderlich.bootcamp.blockbusterrecyclerview.model.Movie
import com.raywenderlich.bootcamp.blockbusterrecyclerview.model.MovieDatabase
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

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

        favorite_imageButton.setOnClickListener {
            val database = MovieDatabase.getDatabase(this)

            GlobalScope.launch {
                val foundedMovie = database.movieDao().finById(movie.id)
                var message =  ""
                if (foundedMovie == null) {
                    database.movieDao().insert(movie)
                    message = getString(R.string.add_to_favorites_message)
                } else {
                    database.movieDao().delete(movie)
                    message = getString(R.string.remove_from_favorites_message)
                }
                showMessage(message)
            }
        }
    }


    private fun showMessage(message: String) {
        val snackbar = Snackbar.make(favorite_imageButton, message, Snackbar.LENGTH_LONG)
        snackbar.show()
    }
}