package com.hardeylim.movlancer.usecase.movie

import dagger.Binds
import dagger.Module

@Module
abstract class MovieUsecaseModule {

    @Binds
    internal abstract fun provideMovieLoader(defaultMovieLoader: DefaultMovieLoader) : MovieLoader
}