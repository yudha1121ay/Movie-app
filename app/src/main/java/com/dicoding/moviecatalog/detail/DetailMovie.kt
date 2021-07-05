package com.dicoding.moviecatalog.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.dicoding.moviecatalog.R
import com.dicoding.moviecatalog.core.domain.model.MovieVar
import com.dicoding.moviecatalog.core.utils.ListURL.IMAGE_URL
import com.dicoding.moviecatalog.databinding.ActivityDetailMovieBinding
import org.koin.android.viewmodel.ext.android.viewModel


class DetailMovie : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private val detailModel: DetailModel by viewModel()
    private lateinit var binding: ActivityDetailMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val movies = intent.getParcelableExtra<MovieVar>(EXTRA_DATA)
        showDetailMovies(movies)
    }

    private fun showDetailMovies(movies : MovieVar?) {
        movies?.let {
            supportActionBar?.title = movies.title
            binding.detailContent.mvDesc.text = movies.overview
            binding.detailContent.mvJudul.text = movies.title
            binding.detailContent.mvRelease.text = movies.releaseDate
            binding.detailContent.mvDurasi.text = movies.originalLanguage
            binding.detailContent.mvDirector.text = movies.voteAverage.toString()
            Glide.with(this@DetailMovie)
                .load(IMAGE_URL + movies.posterPath)
                .transform(RoundedCorners(40))
                .into(binding.detailContent.moviePoster)

            var statusFavorite = movies.isFav
            setStatusFavorite(statusFavorite)
            binding.btnFavorite.setOnClickListener {
                statusFavorite = !statusFavorite
                detailModel.setFavoriteMovies(movies, statusFavorite)
                setStatusFavorite(statusFavorite)
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.btnFavorite.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_fav_full))
        } else {
            binding.btnFavorite.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_fav_border))
        }
    }
}