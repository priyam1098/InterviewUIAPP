package com.example.interviewapp.NetworkModule

import com.example.interviewapp.Model.MovieModel
import retrofit2.Response
import retrofit2.http.GET

interface MovieInterface {

    @GET("api/v1/movies")
    suspend fun getMovies():Response<List<MovieModel>>
}