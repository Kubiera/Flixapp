package com.example.flixapp

import com.google.gson.annotations.SerializedName

class Movie {

    @SerializedName("title")
    var title: String? = null

    @SerializedName("poster_path")
    var movieImage: String? = null

    @SerializedName("overview")
    var description: String? = null

    @SerializedName("vote_average")
    var voteAverage: Float? = null

    @SerializedName("popularity")
    var popularity: Float? = null
}