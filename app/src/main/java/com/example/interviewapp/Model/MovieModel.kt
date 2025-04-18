package com.example.interviewapp.Model

data class MovieModel(
    var id : Int,
    var title : String,
    var year : Int,
    var rating : Double,
    var director : String,
    var poster : String,
    var genre : List<String>?
)
