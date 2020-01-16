package com.hardeylim.movlancer.model

import com.google.gson.annotations.SerializedName

data class Movie(
        @SerializedName("popularity")
        var popularity: Double = 0.0, // 66.895
        @SerializedName("vote_count")
        var voteCount: Int = 0, // 256
        @SerializedName("video")
        var video: Boolean = false, // false
        @SerializedName("poster_path")
        var posterPath: String = "", // /y9IcwcD95wCPR3IGbzlZ00f64Sj.jpg
        @SerializedName("id")
        var id: Int = 0, // 540901
        @SerializedName("adult")
        var adult: Boolean = false, // false
        @SerializedName("backdrop_path")
        var backdropPath: String = "", // /5GynP6w2OQWSbKnCLHrBIriF4Cw.jpg
        @SerializedName("original_language")
        var originalLanguage: String = "", // en
        @SerializedName("original_title")
        var originalTitle: String = "", // Hustlers
        @SerializedName("genre_ids")
        var genreIds: List<Int> = listOf(),
        @SerializedName("title")
        var title: String = "", // Hustlers
        @SerializedName("vote_average")
        var voteAverage: Double = 0.0, // 6.2
        var rating: Float = 0F, // voteAverage/2
        @SerializedName("overview")
        var overview: String = "", // A crew of savvy former strip club employees band together to turn the tables on their Wall Street clients.
        @SerializedName("release_date")
        var releaseDate: String = "" // 2019-09-13
)