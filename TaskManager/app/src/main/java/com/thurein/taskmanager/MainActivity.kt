package com.thurein.taskmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thurein.taskmanager.ui.theme.TaskManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskManagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DisplayFullPage()
                }
            }
        }
    }
}
@Composable
fun DisplayingImage(modifier: Modifier=Modifier){
    val image = painterResource(id = R.drawable.ic_task_completed)
    Image(painter = image, contentDescription = null)
}

@Composable
fun DisplayingText(title:String,modifier: Modifier=Modifier){
    Text(text = title, fontSize = 16.sp)
}

@Composable
fun DisplayingBoldText(title:String,modifier: Modifier=Modifier){
    Text(text = title, fontWeight = FontWeight.Bold, modifier = Modifier.padding(8.dp,24.dp)
    )
}

@Composable
fun DisplayFullPage(modifier: Modifier=Modifier){
    Column(modifier = modifier, verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        DisplayingImage()
        DisplayingBoldText(title = "All tasks completed")
        DisplayingText(title = "Nice work!")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TaskManagerTheme {
        DisplayingImage()
    }
}