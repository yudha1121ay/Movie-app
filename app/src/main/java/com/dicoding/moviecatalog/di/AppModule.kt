package com.dicoding.moviecatalog.di

import com.dicoding.moviecatalog.core.domain.usecase.MovieCatalogInteractor
import com.dicoding.moviecatalog.core.domain.usecase.MovieCatalogUseCase
import com.dicoding.moviecatalog.detail.DetailModel
import com.dicoding.moviecatalog.ui.viewmodel.MovieModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<MovieCatalogUseCase> { MovieCatalogInteractor(get()) }
}

val viewModelModule = module {
    viewModel { MovieModel(get()) }
    viewModel { DetailModel(get()) }
}