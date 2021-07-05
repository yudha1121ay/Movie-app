package com.dicoding.moviecatalog.favorite.di

import com.dicoding.moviecatalog.favorite.viewmodel.FavMovieModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val favoriteModule = module {
    viewModel { FavMovieModel(get()) }
}