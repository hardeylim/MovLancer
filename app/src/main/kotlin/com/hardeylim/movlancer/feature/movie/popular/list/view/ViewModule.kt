package com.hardeylim.movlancer.feature.movie.popular.list.view

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ViewModule {
    //Contributes Android Injector says that this activity can be injected.
    @ContributesAndroidInjector
    internal abstract fun popularMoviesActivity(): PopularMoviesActivity
}