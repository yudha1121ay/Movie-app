package com.dicoding.moviecatalog.core.data.source.remote

import android.util.Log
import com.dicoding.moviecatalog.core.api.ApiResponse
import com.dicoding.moviecatalog.core.api.ApiService
import com.dicoding.moviecatalog.core.data.source.remote.response.movie.Movie
import com.dicoding.moviecatalog.core.utils.ListURL.API_KEY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val apiService: ApiService){

    suspend fun getMovies(): Flow<ApiResponse<List<Movie>>> {
        return flow {
            try {
                val response = apiService.getMovies(API_KEY)
                val movies = response.results
                if (movies.isNotEmpty()) {
                    emit(ApiResponse.Success(response.results))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e : Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}