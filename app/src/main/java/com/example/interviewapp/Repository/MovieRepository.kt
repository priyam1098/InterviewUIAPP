package com.example.interviewapp.Repository

import com.example.interviewapp.Model.MovieModel
import com.example.interviewapp.NetworkModule.MovieInterface
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class MovieRepository @Inject constructor(private val repository: MovieInterface) {

    fun getMovies(): Flow<Result<List<MovieModel>>> = flow{

        try {
            var response = repository.getMovies()
            if (response.isSuccessful && response.body() != null) {
                emit(Result.success(response.body()!!))

            }
        }
        catch (e: IOException){
            emit(Result.failure(Exception("network error ${e.message}")))

        }
        catch (e: HttpException){
            emit(Result.failure(Exception("Http Error ${e.message}")))

        }

    }
}