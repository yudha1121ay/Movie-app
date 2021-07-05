package com.dicoding.moviecatalog.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class MovieVar(
    val id: Int,
    val overview: String,
    val originalLanguage: String,
    val releaseDate: String,
    val popularity: Double,
    val voteAverage: Double,
    val title: String,
    val posterPath: String,
    val voteCount: Int,
    val isFav: Boolean
) : Parcelable