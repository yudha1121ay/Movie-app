package com.dicoding.moviecatalog.core.api

import com.dicoding.moviecatalog.core.data.source.remote.response.movie.Movies
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("discover/movie")
    suspend fun getMovies(@Query("api_key") apiKey: String) : Movies
}