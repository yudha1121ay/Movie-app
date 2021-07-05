package com.dicoding.moviecatalog.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie_entities")
data class MovieEntity(
        @PrimaryKey
        @NonNull
        @ColumnInfo(name = "id")
        var id: Int,

        @ColumnInfo(name = "overview")
        var overview: String,

        @ColumnInfo(name = "original_language")
        var originalLanguage: String,

        @ColumnInfo(name = "release_ate")
        var releaseDate: String,

        @ColumnInfo(name = "popularity")
        var popularity: Double,

        @ColumnInfo(name = "voteAverage")
        var voteAverage: Double,

        @ColumnInfo(name = "title")
        var title: String,

        @ColumnInfo(name = "posterPath")
        var posterPath: String,

        @ColumnInfo(name = "vote_count")
        var voteCount: Int,

        @ColumnInfo(name = "isFav")
        var isFav: Boolean = false
)