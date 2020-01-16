package com.hardeylim.movlancer.feature.movie.popular.list.usecase.mapper

import com.hardeylim.movlancer.BuildConfig.IMAGE_BASE_URL
import com.hardeylim.movlancer.model.Movie
import com.hardeylim.movlancer.model.PopularMovies
import com.hardeylim.movlancer.usecase.movie.model.MovieDto
import com.hardeylim.movlancer.usecase.movie.model.PopularMoviesDto
import io.reactivex.Single
import io.reactivex.SingleSource
import io.reactivex.SingleTransformer
import java.util.*

class DtoToPopularMoviesMapper :
    //Function<PopularMoviesDto, Single<PopularMovies>>,
    SingleTransformer<PopularMoviesDto, PopularMovies> {
    override fun apply(upstream: Single<PopularMoviesDto>): SingleSource<PopularMovies> {
        return upstream.flatMap {dto: PopularMoviesDto ->
            val popularMovies = PopularMovies()
            popularMovies.page = dto.page
            popularMovies.totalPages = dto.totalPages
            popularMovies.totalResults = dto.totalResults
            popularMovies.movies = mapMoviesDtoToMovies(dto.movies)
            Single.just(popularMovies)
        }
    }
//    override fun apply(dto: PopularMoviesDto): Single<PopularMovies> {
//        return Single.fromCallable{
//            val popularMovies = PopularMovies()
//            popularMovies.page = dto.page
//            popularMovies.totalPages = dto.totalPages
//            popularMovies.totalResults = dto.totalResults
//            popularMovies.movies = mapMoviesDtoToMovies(dto.movies)
//            popularMovies
//        }
//    }

    private fun mapMoviesDtoToMovies(dtos: LinkedList<MovieDto>) : LinkedList<Movie>{
        val movies = LinkedList<Movie>()
        dtos.forEach{dto : MovieDto ->
            movies.add(mapMovieDtoToMovie(dto))
        }
        return movies
    }

    private fun mapMovieDtoToMovie(dto : MovieDto): Movie{
        val movie = Movie()
        movie.adult = dto.adult
        dto.backdropPath?.run {
            movie.backdropPath = this
        }
        movie.genreIds = dto.genreIds
        movie.id = dto.id
        movie.originalLanguage = dto.originalLanguage
        movie.originalTitle = dto.originalTitle
        movie.overview = dto.overview
        movie.popularity = dto.popularity
        movie.releaseDate = dto.releaseDate
        movie.title = dto.title
        movie.video = dto.video
        movie.posterPath = buildImageUrl(dto.posterPath)
        movie.voteAverage = dto.voteAverage
        movie.rating = setRating(dto)
        movie.voteCount = dto.voteCount
        return movie
    }

    private fun setRating(dto: MovieDto) =
        dto.voteAverage.div(2).toFloat()

    private fun buildImageUrl(url: String): String = IMAGE_BASE_URL+"original"+url
}