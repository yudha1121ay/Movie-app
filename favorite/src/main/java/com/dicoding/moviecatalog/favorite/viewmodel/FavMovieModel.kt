package com.dicoding.moviecatalog.favorite.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.moviecatalog.core.domain.usecase.MovieCatalogUseCase

class FavMovieModel (useCase: MovieCatalogUseCase) : ViewModel() {
    val favMovies = useCase.getFavoriteMovies().asLiveData()
}