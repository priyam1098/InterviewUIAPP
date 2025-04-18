package com.example.interviewapp.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.interviewapp.Model.MovieModel
import com.example.interviewapp.NavigationGraph.ScreenRoutes
import com.example.interviewapp.viewModel.MovieViewModel
import kotlinx.coroutines.delay


@Composable
fun MovieView (navController : NavController, viewModel: MovieViewModel){
    val movies = viewModel.moviesData.collectAsState().value.getOrNull() ?: emptyList()
    var search by remember {
        mutableStateOf("")
    }


    LaunchedEffect(Unit) {
        viewModel.getMoviesData()
    }

    Column(modifier = Modifier.fillMaxSize().padding(top = 70.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(value = search ,
            onValueChange = {search= it},
            placeholder = { Text(text = "Movie Name") },
            modifier = Modifier.padding(start =40.dp,end=40.dp).fillMaxWidth()
        )
        Spacer(modifier = Modifier.padding(2.dp))
        if(movies.isEmpty()){
            Text(text = "No movies found")
        }
        else{
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(movies) {movie->
                    MovieItemCard(movie = movie , navController = navController, viewModel = viewModel)
                }
            }

        }


        Spacer(modifier = Modifier.padding(6.dp))

    }
}
@Composable
fun MovieItemCard(navController: NavController, viewModel: MovieViewModel, movie: MovieModel
) {
    var isClicked by remember {
        mutableStateOf(false)
    }
    if (isClicked) {
        LaunchedEffect(isClicked) {
            if (isClicked) {
                delay(100)
                navController.navigate(ScreenRoutes.MovieDetailScreen.route)
            }
        }
    }
    Card(modifier = Modifier.fillMaxWidth().padding(start =40.dp,end=40.dp, top = 4.dp, bottom = 4.dp)
        .clickable{
            viewModel.setSelectedMovie(movie)
            isClicked = true},
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp,

        )
    ) {
        Row (modifier = Modifier.padding(10.dp).fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween ){
            Text(text = "${movie.title}")
            Text(text = "${movie.year}")

        }
    }

}

