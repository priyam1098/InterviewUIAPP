package com.example.interviewapp.viewModel

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

    fun getMoviesData(){
        viewModelScope.launch {
            viewModel.getMovies().collect {
                result ->
                _moviesData.value = result

            }
        }
    }
}