package com.example.interviewapp.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.interviewapp.Model.MovieModel
import com.example.interviewapp.Repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val viewModel: MovieRepository): ViewModel() {

    private var _moviesData = MutableStateFlow<Result<List<MovieModel>>>(Result.success(emptyList()))
    var moviesData : StateFlow<Result<List<MovieModel>>> = _moviesData

    private val _selectedMovie = MutableStateFlow<MovieModel?>(null)
    var selectedMovie : StateFlow<MovieModel?> = _selectedMovie

    fun getMoviesData(){
        viewModelScope.launch {
            viewModel.getMovies().collect {
                result ->
                _moviesData.value = result

            }
        }
    }
    fun setSelectedMovie(movie : MovieModel){
        _selectedMovie.value = movie
        Log.d("Movie model-->", "selected value: ${movie.title}")
    }
}