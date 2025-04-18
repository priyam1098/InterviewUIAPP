package com.example.interviewapp.NavigationGraph

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.interviewapp.viewModel.MovieViewModel
import com.example.interviewapp.views.MovieView
import com.example.interviewapp.views.MoviesDetail

@Composable
fun AppNavigation(){

    var navController = rememberNavController()
    val viewModel: MovieViewModel = hiltViewModel()

    NavHost(navController, startDestination = "HomeScreen") {

            composable(ScreenRoutes.HomeScreen.route) {
                MovieView(navController, viewModel) }
            composable(ScreenRoutes.MovieDetailScreen.route) {
                MoviesDetail(navController = navController, viewModel = viewModel)
            }

    }

}
