package com.example.interviewapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.interviewapp.NavigationGraph.AppNavigation
import com.example.interviewapp.ui.theme.InterviewAppTheme
import com.example.interviewapp.views.MovieView
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppNavigation()
            //MovieViewPreview()
        }
    }
}



@Preview(showBackground = true)
@Composable
fun MovieViewPreview() {
    InterviewAppTheme {
        //MovieView()
    }
}