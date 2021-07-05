package com.dicoding.moviecatalog.core.data.source.local.room

import androidx.room.*
import com.dicoding.moviecatalog.core.data.source.local.entity.MovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Query("SELECT * FROM movie_entities")
    fun getMovies(): Flow<List<MovieEntity>>

    @Query("SELECT * FROM movie_entities WHERE isFav = 1")
    fun getFavMovies(): Flow<List<MovieEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(movies: List<MovieEntity>)

    @Update
    fun updateMovie(movie: MovieEntity)
}