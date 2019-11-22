package com.hardeylim.movlancer.model


import com.google.gson.annotations.SerializedName
import java.util.*

data class PopularMovies(
    @SerializedName("page")
    var page: Int = 0, // 1
    @SerializedName("total_results")
    var totalResults: Int = 0, // 10000
    @SerializedName("total_pages")
    var totalPages: Int = 0, // 500
    @SerializedName("results")
    var movies: LinkedList<Movie> = LinkedList()
)
