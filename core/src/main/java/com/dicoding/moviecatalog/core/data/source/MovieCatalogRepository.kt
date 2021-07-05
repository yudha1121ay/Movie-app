package com.dicoding.moviecatalog.core.data.source

import com.dicoding.moviecatalog.core.api.ApiResponse
import com.dicoding.moviecatalog.core.data.source.local.LocalDataSource
import com.dicoding.moviecatalog.core.data.source.remote.RemoteDataSource
import com.dicoding.moviecatalog.core.data.source.remote.response.movie.Movie
import com.dicoding.moviecatalog.core.domain.model.MovieVar
import com.dicoding.moviecatalog.core.domain.repository.IMovieCatalogRepository
import com.dicoding.moviecatalog.core.utils.AppExecutors
import com.dicoding.moviecatalog.core.utils.DataMapper
import com.dicoding.moviecatalog.core.vo.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MovieCatalogRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IMovieCatalogRepository {

    override fun getMovies(): Flow<Resource<List<MovieVar>>> =
        object : NetworkBoundResource<List<MovieVar>, List<Movie>>() {
            override fun loadFromDb(): Flow<List<MovieVar>> {
                return localDataSource.getMovies().map{
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<MovieVar>?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<List<Movie>>> {
                return remoteDataSource.getMovies()
            }

            override suspend fun saveCallResult(data: List<Movie>) {
                val movieList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertMovies(movieList)
            }
        }.asFlow()

    override fun getFavoriteMovies(): Flow<List<MovieVar>> {
        return localDataSource.getFavMovies().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setFavoriteMovies(movie: MovieVar, state: Boolean) {
        val movieEntity = DataMapper.mapDomainToEntity(movie)
        appExecutors.diskIO().execute { localDataSource.setFavoriteMovie(movieEntity, state)
        }
    }
}