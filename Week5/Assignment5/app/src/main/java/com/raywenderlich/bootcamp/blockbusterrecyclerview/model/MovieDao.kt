package com.raywenderlich.bootcamp.blockbusterrecyclerview.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MovieDao {

    @Query("SELECT * FROM movie_table")
    fun getAllMovies(): List<Movie>

    @Insert
    fun insert(vararg  movie: Movie)

    @Delete
    fun delete(movie: Movie)

    @Query("SELECT * FROM MOVIE_TABLE WHERE id = :id")
    fun finById(id: String): Movie?
}