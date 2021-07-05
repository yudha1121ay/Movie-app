package com.dicoding.moviecatalog.core.domain.usecase

import com.dicoding.moviecatalog.core.domain.model.MovieVar
import com.dicoding.moviecatalog.core.domain.repository.IMovieCatalogRepository

class MovieCatalogInteractor(private val mvcatalogrepo: IMovieCatalogRepository) : MovieCatalogUseCase {
    //Movies
    override fun getMovies() = mvcatalogrepo.getMovies()
    override fun getFavoriteMovies() = mvcatalogrepo.getFavoriteMovies()
    override fun setFavoriteMovies(movie: MovieVar, state: Boolean) = mvcatalogrepo.setFavoriteMovies(movie, state)
}