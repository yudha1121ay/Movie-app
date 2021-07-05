package com.dicoding.moviecatalog.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.moviecatalog.core.domain.usecase.MovieCatalogUseCase

class MovieModel(useCase: MovieCatalogUseCase) : ViewModel() {
    val getMovies = useCase.getMovies().asLiveData()
}