package com.example.lab_week_13.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
@JsonClass(generateAdapter = true)
data class Movie(
    @PrimaryKey
    @Json(name = "id") val id: Int,

    @Json(name = "title") val title: String?,
    @Json(name = "overview") val overview: String?,
    @Json(name = "poster_path") val posterPath: String?,
    @Json(name = "backdrop_path") val backdropPath: String? = "",
    @Json(name = "vote_average") val rating: Double?,
    @Json(name = "release_date") val releaseDate: String?,
    @Json(name = "popularity") val popularity: Double?
)

