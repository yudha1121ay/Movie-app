package com.dicoding.moviecatalog.core.domain.repository

import com.dicoding.moviecatalog.core.domain.model.MovieVar
import com.dicoding.moviecatalog.core.vo.Resource
import kotlinx.coroutines.flow.Flow

interface IMovieCatalogRepository {
    //Movies
    fun getMovies(): Flow<Resource<List<MovieVar>>>
    fun getFavoriteMovies(): Flow<List<MovieVar>>
    fun setFavoriteMovies(movie: MovieVar, state:Boolean)
}