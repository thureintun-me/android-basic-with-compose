package com.thurein.composequardant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.magnifier
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thurein.composequardant.ui.theme.ComposeQuardantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuardantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Surface(modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background) {
                        Quardant()
                    }
                }
            }
        }
    }
}

@Composable
fun Quardant(){

    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.weight(1f)) {

            Card(
                title = stringResource(R.string.first_title),
                backgroundColor = Color(0xFFB69DF8),
                paragraph = stringResource(R.string.first_description),
                modifier = Modifier.weight(1f)
            )
            Card(
                title = stringResource(R.string.second_title),
                backgroundColor = Color(0xFFF6EDFF),
                paragraph =  stringResource(R.string.second_description),
                modifier = Modifier.weight(1f)
            )


        }
        Row(Modifier.weight(1f)) {

            Card(
                title = stringResource(R.string.third_title),
                backgroundColor = Color(0xFFF6EDFF),
                paragraph = stringResource(R.string.third_description),
                modifier = Modifier.weight(1f))
            Card(title = stringResource(R.string.fourth_title),
                backgroundColor = Color(0xFFB69DF8),
                paragraph = stringResource(id = R.string.fourth_description),
                modifier = Modifier.weight(1f))



        }
    }



}

@Composable
fun Card(title: String,paragraph:String,  backgroundColor: Color, modifier: Modifier = Modifier) {
    Column(
            modifier = modifier
                .fillMaxSize()
                .background(backgroundColor)
                .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = title,
            modifier = Modifier.padding(bottom = 16.dp),
            fontWeight = FontWeight.Bold
        )
        Text(text = paragraph, textAlign = TextAlign.Justify)
    }

}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeQuardantTheme {

    Quardant()
    }
}


