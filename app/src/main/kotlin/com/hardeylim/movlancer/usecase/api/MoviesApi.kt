package com.hardeylim.movlancer.usecase.api

import com.hardeylim.movlancer.model.PopularMovies
import com.hardeylim.movlancer.usecase.movie.model.PopularMoviesDto
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {

    @GET("$V3/movie/popular")
    fun getPopular(@Query("api_key") apiKey : String): Single<PopularMoviesDto>

    companion object {
        const val V3 = "3"
    }
}