package com.hardeylim.movlancer.model


import com.google.gson.annotations.SerializedName
import java.util.*

data class PopularMovies(
    @SerializedName("page")
    val page: Int = 0, // 1
    @SerializedName("total_results")
    val totalResults: Int = 0, // 10000
    @SerializedName("total_pages")
    val totalPages: Int = 0, // 500
    @SerializedName("results")
    val movies: LinkedList<Movie> = LinkedList()
)
