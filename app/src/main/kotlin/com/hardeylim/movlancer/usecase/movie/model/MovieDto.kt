package com.hardeylim.movlancer.usecase.movie.model

import com.google.gson.annotations.SerializedName

data class MovieDto(
    @SerializedName("popularity")
    val popularity: Double = 0.0, // 66.895
    @SerializedName("vote_count")
    val voteCount: Int = 0, // 256
    @SerializedName("video")
    val video: Boolean = false, // false
    @SerializedName("poster_path")
    val posterPath: String = "", // /y9IcwcD95wCPR3IGbzlZ00f64Sj.jpg
    @SerializedName("id")
    val id: Int = 0, // 540901
    @SerializedName("adult")
    val adult: Boolean = false, // false
    @SerializedName("backdrop_path")
    val backdropPath: String = "", // /5GynP6w2OQWSbKnCLHrBIriF4Cw.jpg
    @SerializedName("original_language")
    val originalLanguage: String = "", // en
    @SerializedName("original_title")
    val originalTitle: String = "", // Hustlers
    @SerializedName("genre_ids")
    val genreIds: List<Int> = listOf(),
    @SerializedName("title")
    val title: String = "", // Hustlers
    @SerializedName("vote_average")
    val voteAverage: Double = 0.0, // 6.2
    @SerializedName("overview")
    val overview: String = "", // A crew of savvy former strip club employees band together to turn the tables on their Wall Street clients.
    @SerializedName("release_date")
    val releaseDate: String = "" // 2019-09-13
)