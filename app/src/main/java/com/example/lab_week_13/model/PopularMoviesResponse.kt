package com.example.lab_week_13.model

import com.example.lab_week_13.model.Movie
import com.squareup.moshi.Json

data class PopularMoviesResponse(
    @Json(name = "page") val page: Int,
    @Json(name = "results") val results: List<Movie>,
    @Json(name = "total_pages") val totalPages: Int,
    @Json(name = "total_results") val totalResults: Int
)