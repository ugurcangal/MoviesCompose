package com.example.movieappcompose.domain.use_case.get_movies

import com.example.movieappcompose.data.remote.dto.toMovieList
import com.example.movieappcompose.domain.model.Movie
import com.example.movieappcompose.domain.repository.MovieRepository
import com.example.movieappcompose.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOError
import javax.inject.Inject

class GetMovieUseCase @Inject constructor(private val repository: MovieRepository) {

    fun executeGetMovies(search: String) : Flow<Resource<List<Movie>>> = flow {
        try {
            emit(Resource.Loading())
            val movieList = repository.getMovies(search)
            if (movieList.Response.equals("True")){
                emit(Resource.Success(movieList.toMovieList()))
            }else{
                emit(Resource.Error(message = "No movie found!"))
            }
        }catch (e: IOError){
            emit(Resource.Error(message = e.message.toString()))
        }
    }

}