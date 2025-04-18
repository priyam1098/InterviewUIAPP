package com.example.interviewapp.NavigationGraph

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.interviewapp.views.MovieView
import com.example.interviewapp.views.MoviesDetail

@Composable
fun AppNavigation(){

    var navController = rememberNavController()
    NavHost(navController, startDestination = "HomeScreen"){
        composable(ScreenRoutes.HomeScreen.route){ MovieView(navController) }
        composable(ScreenRoutes.MovieDetailScreen.route) { MoviesDetail(navController) }
    }

}
