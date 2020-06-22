package com.raywenderlich.bootcamp.blockbusterrecyclerview.model

import com.raywenderlich.bootcamp.blockbusterrecyclerview.R

class MoviesDataSource {

    companion object {
        fun getMoviesList(): ArrayList<Movie>  = arrayListOf(
               Movie(
                   "1",
                   "Paddington",
                   "November 28, 2014",
                   R.drawable.paddington_poster,
                   R.drawable.paddington_banner,
                   "11",
                   "A young Peruvian bear travels to London in search of a home. " +
                           "Finding himself lost and alone at Paddington Station, he meets the " +
                           "kindly Brown family, who offer him a temporary haven."
               ),
                Movie(
                    "2",
                    "Paddington 2",
                    "November 5, 2017 ",
                    R.drawable.paddington_poster,
                    R.drawable.paddington_banner,
                    "11",
                    "Paddington (Ben Whishaw), now happily settled with the Brown family " +
                            "and a popular member of the local community, picks up a series of odd " +
                            "jobs to buy the perfect present for his Aunt Lucy's (Imelda Staunton's) " +
                            "100th birthday, only for the gift to be stolen."
                ),
                Movie(
                    "3",
                    "The Dark Knight",
                    "July 14, 2008",
                    R.drawable.paddington_poster,
                    R.drawable.paddington_banner,
                    "9",
                    "When the menace known as the Joker wreaks havoc and chaos on the " +
                            "people of Gotham, Batman must accept one of the greatest psychological " +
                            "and physical tests of his ability to fight injustice."
                ),
                Movie(
                    "4",
                    "Her",
                    "October 13, 2013",
                    R.drawable.paddington_poster,
                    R.drawable.paddington_banner,
                    "8",
                    "In a near future, a lonely writer develops an unlikely relationship " +
                            "with an operating system designed to meet his every need."
                ),
                Movie(
                    "5",
                    "La La Land",
                    "December 9, 2016",
                    R.drawable.paddington_poster,
                    R.drawable.paddington_banner,
                    "8",
                    "While navigating their careers in Los Angeles, a pianist and an " +
                            "actress fall in love while attempting to reconcile their aspirations " +
                            "for the future."
                )
            )
    }
}