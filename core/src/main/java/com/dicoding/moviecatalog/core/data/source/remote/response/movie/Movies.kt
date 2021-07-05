package com.dicoding.moviecatalog.core.data.source.remote.response.movie

import com.google.gson.annotations.SerializedName

data class Movies (
    @field:SerializedName("results")
    val results: List<Movie>
)