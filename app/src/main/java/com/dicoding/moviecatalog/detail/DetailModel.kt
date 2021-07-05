package com.dicoding.moviecatalog.detail

import androidx.lifecycle.ViewModel
import com.dicoding.moviecatalog.core.domain.model.MovieVar
import com.dicoding.moviecatalog.core.domain.usecase.MovieCatalogUseCase

class DetailModel(private val useCase: MovieCatalogUseCase): ViewModel() {
    //Movies
    fun setFavoriteMovies(movie: MovieVar, newStatus:Boolean) =
        useCase.setFavoriteMovies(movie, newStatus)
}