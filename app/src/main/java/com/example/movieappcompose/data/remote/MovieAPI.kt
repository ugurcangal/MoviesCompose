package com.example.movieappcompose.data.remote

import com.example.movieappcompose.data.remote.dto.MovieDetailDto
import com.example.movieappcompose.data.remote.dto.MoviesDto
import com.example.movieappcompose.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query


interface MovieAPI {

    @GET(".")
    suspend fun getMovies(
        @Query("s") searchString: String,
        @Query("apiKey") apiKey: String = API_KEY
    ) : MoviesDto

    @GET(".")
    suspend fun getMovieDetail(
        @Query("i") imdbId: String,
        @Query("apiKey") apiKey: String = API_KEY
    ) : MovieDetailDto




}