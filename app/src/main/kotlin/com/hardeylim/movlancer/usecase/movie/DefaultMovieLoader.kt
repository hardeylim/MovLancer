package com.hardeylim.movlancer.usecase.movie

import com.hardeylim.movlancer.usecase.internet.InternetChecker
import com.hardeylim.movlancer.usecase.api.MoviesApi
import com.hardeylim.movlancer.usecase.movie.model.PopularMoviesDto
import io.reactivex.Single
import io.reactivex.annotations.SchedulerSupport
import javax.inject.Inject

class DefaultMovieLoader
@Inject
internal constructor(
    private val internetChecker: InternetChecker,
    private val moviesApi: MoviesApi
) : MovieLoader {

    @SchedulerSupport(SchedulerSupport.IO)
    override fun getPopularMovies(apiKey: String): Single<PopularMoviesDto> =
        internetChecker.checkInternet()
            .andThen(moviesApi.getPopular(apiKey))
}