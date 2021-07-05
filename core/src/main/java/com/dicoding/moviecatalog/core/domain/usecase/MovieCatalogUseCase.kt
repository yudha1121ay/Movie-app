package com.dicoding.moviecatalog.core.domain.usecase

import com.dicoding.moviecatalog.core.domain.model.MovieVar
import com.dicoding.moviecatalog.core.vo.Resource
import kotlinx.coroutines.flow.Flow

interface MovieCatalogUseCase {
    fun getMovies(): Flow<Resource<List<MovieVar>>>
    fun getFavoriteMovies(): Flow<List<MovieVar>>
    fun setFavoriteMovies(movie: MovieVar, state:Boolean)
}