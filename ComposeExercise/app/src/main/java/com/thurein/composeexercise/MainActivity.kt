package com.thurein.composeexercise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thurein.composeexercise.ui.theme.ComposeExerciseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeExerciseTheme {
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
fun HeaderImage(modifier: Modifier=Modifier){
    val image = painterResource(id = R.drawable.bg_compose_background)
    Image(painter = image, contentDescription = null)
}

@Composable
fun Title(title:String,modifier: Modifier=Modifier){
    Text(
        text = title,
        fontSize = 24.sp,
        modifier= modifier.padding(16.dp),

    )
}
@Composable
fun DisplayParagraph(paragraph:String,modifier: Modifier=Modifier){
    Text(text = paragraph, textAlign = TextAlign.Justify,modifier= modifier.padding(16.dp))
}

@Composable
fun DisplayFullPage(modifier: Modifier=Modifier){
    Column(modifier = modifier){
        HeaderImage()
        Title(title = "Jetpack Compose tutorial")
        DisplayParagraph(paragraph = "Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.")
        DisplayParagraph(paragraph = "In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app\\'s UI programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI\\'s construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name.")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeExerciseTheme {
        DisplayFullPage()
    }
}