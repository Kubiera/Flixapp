package com.example.flixapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class MovieActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie)

        val title = findViewById<TextView>(R.id.movieTitle)
        val image = findViewById<ImageView>(R.id.movieImage)
        val popularity = findViewById<TextView>(R.id.moviePop)
        val average = findViewById<TextView>(R.id.movieAvg)
        val description = findViewById<TextView>(R.id.movieDesc)


        title.text = intent.getStringExtra("MovieTitle")
        popularity.text = "Popularity: " + intent.getStringExtra("MoviePop")
        average.text = "Rating: " + intent.getStringExtra("MovieAVG")
        description.text = intent.getStringExtra("MovieDesc")

        Glide.with(applicationContext)
            .load("https://image.tmdb.org/t/p/w500/" + intent.getStringExtra("MovieImage"))
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.notfound)
            .centerInside()
            .into(image)

    }
}