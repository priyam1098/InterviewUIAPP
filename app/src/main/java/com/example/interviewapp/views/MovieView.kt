package com.example.interviewapp.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.interviewapp.ui.theme.InterviewAppTheme
import org.w3c.dom.Text

@Composable
fun MovieView (navController : NavController){

    Column(modifier = Modifier.fillMaxSize().padding(top = 70.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(value = "" ,
            onValueChange = {},
            placeholder = { Text(text = "Movie Name") },
            modifier = Modifier.padding(start =40.dp,end=40.dp).fillMaxWidth()
        )
        Spacer(modifier = Modifier.padding(2.dp))
        MovieItemCard()

        Spacer(modifier = Modifier.padding(6.dp))

    }
}
@Composable
fun MovieItemCard(){
    Card(modifier = Modifier.fillMaxWidth().padding(start =40.dp,end=40.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row (modifier = Modifier.padding(10.dp).fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween ){
            Text(text = "Hello")
            Text(text = "Hello")

        }
    }

}

@Preview(showBackground = true)
@Composable
fun MovieViewPreview() {
    InterviewAppTheme {
        //MovieView(navController : NavController)
    }
}