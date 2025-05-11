package com.example.movieappcompose.presentation.movies

sealed class MoviesEvent {
    data class Search(val searchString: String): MoviesEvent()
}