package com.example.interviewapp.NavigationGraph


sealed class ScreenRoutes(var route : String) {

    object HomeScreen : ScreenRoutes("HomeScreen")
    object MovieDetailScreen : ScreenRoutes("DetailScreen")

}