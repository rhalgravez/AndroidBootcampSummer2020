package com.raywenderlich.bootcamp.blockbusterrecyclerview.model

import java.util.*

class Movie(
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val releaseDate: String,
    val poster: Int,
    val rating: String,
    val summary: String
) {
}