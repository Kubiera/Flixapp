package com.example.flixapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.bumptech.glide.Glide
import com.example.flixapp.R.id

class TopRatedMoviesRecyclerAdapter (
    private val movies: List<Movie>,
    private val mListener: OnListFragmentInteractionListener?,
)
    : RecyclerView.Adapter<TopRatedMoviesRecyclerAdapter.MovieViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int, ): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.top_rated_movie, parent, false)
        return  MovieViewHolder(view)
    }

    inner class MovieViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        var mItem: Movie? = null
        val mMovieTitle: TextView = mView.findViewById<View>(id.movieTitle) as TextView
        val mMovieImage: ImageView = mView.findViewById<View>(id.movieImage) as ImageView

    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]

        holder.mItem = movie
        holder.mMovieTitle.text = movie.title
        Glide.with(holder.mView)
            .load("https://image.tmdb.org/t/p/w500/" + movie.movieImage)
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.notfound)
            .centerInside()
            .into(holder.mMovieImage)

        holder.mView.setOnClickListener {
            holder.mItem?.let { movie ->
                mListener?.onItemClick(movie)
            }
        }
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}