package com.example.interviewapp.views

import android.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.interviewapp.viewModel.MovieViewModel

@Composable
fun MoviesDetail(navController : NavController, viewModel: MovieViewModel){

    val selectedMovie  = viewModel.selectedMovie.collectAsState().value

    Column (modifier = Modifier.fillMaxSize().padding(20.dp, 40.dp,10.dp)){
        IconButton(onClick = {navController.popBackStack()}) {
            Icon(imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back", tint = Color.Black)

        }
    }

    if(selectedMovie!=null){
        Column(modifier = Modifier.fillMaxSize().padding(20.dp,70.dp,10.dp,10.dp),
            verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally)
        {
            selectedMovie?.let {
                    movie ->Column(modifier = Modifier.fillMaxSize().padding(14.dp)) {
                Text(text = "Movie Details:",
                    style = MaterialTheme.typography.titleLarge)
                Spacer(modifier = Modifier.padding(3.dp))

                Text("Movie Rating : ${selectedMovie.rating}", style = MaterialTheme.typography.titleMedium)
                Spacer(modifier = Modifier.padding(3.dp))
                Text("Movie Director : ${selectedMovie.director}", style = MaterialTheme.typography.titleMedium)
                Spacer(modifier = Modifier.padding(3.dp))
                Text("Movie Genre : ${selectedMovie.genre}",  style = MaterialTheme.typography.titleMedium)
                Spacer(modifier = Modifier.padding(3.dp))
                Text("Image Poster" , style = MaterialTheme.typography.titleMedium)
                Spacer(modifier = Modifier.padding(2.dp))
                selectedMovie.poster?.let {
                    Image(painter = rememberAsyncImagePainter(it), contentDescription = "movie poster")
                }
            }
        }

        }
    }
    else{
        Box(modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        )
        {
            Text("Loading movie details",style = MaterialTheme.typography.titleMedium)
        }

    }

    }

