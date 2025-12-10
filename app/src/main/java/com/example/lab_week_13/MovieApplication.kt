package com.example.lab_week_13

import android.app.Application
import com.example.lab_week_13.api.MovieService
import com.example.lab_week_13.database.MovieDatabase
import com.example.lab_week_13.repository.MovieRepository
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MovieApplication : Application() {
    lateinit var movieRepository: MovieRepository

    override fun onCreate() {
        super.onCreate()

        // 1. Buat instance Moshi dengan KotlinJsonAdapterFactory
        val moshi = com.squareup.moshi.Moshi.Builder()
            .add(com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory())
            .build()

        // 2. Masukkan moshi ke dalam addConverterFactory
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(MoshiConverterFactory.create(moshi)) // Update baris ini
            .build()

        val movieService = retrofit.create(MovieService::class.java)

        val movieDatabase = MovieDatabase.getInstance(applicationContext)
        movieRepository = MovieRepository(movieService, movieDatabase)
    }
}