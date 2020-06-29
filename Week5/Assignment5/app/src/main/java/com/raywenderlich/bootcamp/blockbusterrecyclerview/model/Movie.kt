package com.raywenderlich.bootcamp.blockbusterrecyclerview.model

import android.os.Parcel
import android.os.Parcelable
import java.util.*


class Movie(
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val releaseDate: String,
    val poster: Int,
    val rating: String,
    val summary: String
) : Parcelable
{
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(title)
        parcel.writeString(releaseDate)
        parcel.writeInt(poster)
        parcel.writeString(rating)
        parcel.writeString(summary)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Movie> {
        override fun createFromParcel(parcel: Parcel): Movie {
            return Movie(parcel)
        }

        override fun newArray(size: Int): Array<Movie?> {
            return arrayOfNulls(size)
        }
    }
}