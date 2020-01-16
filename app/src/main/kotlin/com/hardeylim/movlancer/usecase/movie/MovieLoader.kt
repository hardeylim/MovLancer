package com.hardeylim.movlancer.usecase.movie

import com.hardeylim.movlancer.model.PopularMovies
import com.hardeylim.movlancer.usecase.movie.model.PopularMoviesDto
import io.reactivex.Single
import io.reactivex.annotations.SchedulerSupport

interface MovieLoader {
    @SchedulerSupport(value = "io.reactivex:io")
    fun getPopularMovies(apiKey: String): Single<PopularMoviesDto>
}