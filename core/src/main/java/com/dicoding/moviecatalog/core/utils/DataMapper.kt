package com.dicoding.moviecatalog.core.utils

import com.dicoding.moviecatalog.core.data.source.local.entity.MovieEntity
import com.dicoding.moviecatalog.core.data.source.remote.response.movie.Movie
import com.dicoding.moviecatalog.core.domain.model.MovieVar

object DataMapper {
    fun mapResponsesToEntities(input: List<Movie>): List<MovieEntity> {
        val moviesList = ArrayList<MovieEntity>()
        input.map {
            val movie = MovieEntity(
                it.id,
                it.overview,
                it.originalLanguage,
                it.releaseDate,
                it.popularity,
                it.voteAverage,
                it.title,
                it.posterPath,
                it.voteCount,
                false
            )
            moviesList.add(movie)
        }
        return moviesList
    }

    fun mapEntitiesToDomain(input: List<MovieEntity>): List<MovieVar> =
        input.map {
            MovieVar(
                it.id,
                it.overview,
                it.originalLanguage,
                it.releaseDate,
                it.popularity,
                it.voteAverage,
                it.title,
                it.posterPath,
                it.voteCount,
                it.isFav
            )
        }

    fun mapDomainToEntity(input: MovieVar) = MovieEntity (
            input.id,
            input.overview,
            input.originalLanguage,
            input.releaseDate,
            input.popularity,
            input.voteAverage,
            input.title,
            input.posterPath,
            input.voteCount,
            input.isFav
    )
}