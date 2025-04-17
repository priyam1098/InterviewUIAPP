package com.example.interviewapp.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.interviewapp.ui.theme.InterviewAppTheme
import org.w3c.dom.Text

@Composable
fun MovieView (){

    Column(modifier = Modifier.fillMaxSize().padding(8.dp, 30.dp, 8.dp, 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(value = "" , onValueChange = {}, placeholder = { Text(text = "Movie Name") })
        Spacer(modifier = Modifier.padding(2.dp))
        Row (modifier = Modifier.fillMaxSize().padding(30.dp, 8.dp), horizontalArrangement = Arrangement.SpaceBetween ){
            Text(text = "Hello")

            Text(text = "Hello")

        }
        Spacer(modifier = Modifier.padding(6.dp))
        Button(onClick = {}) {
            Text(text = "Click me")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun MovieViewPreview() {
    InterviewAppTheme {
        MovieView()
    }
}