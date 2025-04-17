package com.example.interviewapp.Repository

import com.example.interviewapp.Model.MovieModel
import com.example.interviewapp.NetworkModule.MovieInterface
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class MovieRepository @Inject constructor(private val repository: MovieInterface) {

    fun getMovies(): Flow<MovieModel> = flow{

        try {
            var response = repository.getMovies()
            if (response.isSuccessful && response.body() != null) {
                emit(response.body()!!):q

            }
        }
        catch (e: IOException){

        }

    }
}