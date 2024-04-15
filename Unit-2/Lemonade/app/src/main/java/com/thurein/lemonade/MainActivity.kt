package com.thurein.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thurein.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonadeApp(modifier = Modifier)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LemonadeApp (modifier: Modifier){
    var currentState by remember { mutableStateOf(1) }
    var squeezeCount by remember { mutableStateOf(0) }


    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Lemonade",
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        }
    ){
        innerPadding ->
        Surface(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.tertiaryContainer), color = MaterialTheme.colorScheme.background) {

        when(currentState){
            1 ->{
                LemonadeDisplay(
                    drawableResourceId = R.drawable.lemon_tree,
                    stringResourceId = R.string.lemon_tree,
                    onImageClick = {
                        currentState = 2
                        squeezeCount = (2..4).random()
                    }
                )
            }

            2 ->{
                LemonadeDisplay(
                    drawableResourceId = R.drawable.lemon_squeeze,
                    stringResourceId = R.string.lemon,
                    onImageClick = {
                        squeezeCount--
                        if (squeezeCount == 0) {
                            currentState = 3
                        }

                    }
                )
            }

            3 ->{
                LemonadeDisplay(
                    drawableResourceId = R.drawable.lemon_drink,
                    stringResourceId = R.string.glass_of_lemonade,
                    onImageClick = {
                        currentState = 4
                    }
                )
            }

            4 -> {
                LemonadeDisplay(
                    drawableResourceId = R.drawable.lemon_restart,
                    stringResourceId = R.string.empty_glass,
                    onImageClick = {
                        currentState = 1
                    }
                )
            }

        }
    }
        
    }

}
@Composable
fun LemonadeDisplay(drawableResourceId : Int ,stringResourceId:Int,onImageClick : () -> Unit ,modifier: Modifier=Modifier){



    val descResource = stringResource(id = R.string.lemon_tree)
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = onImageClick) {
            Image(painter = painterResource(id = drawableResourceId), contentDescription = stringResource(
                id = stringResourceId
            ))
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = stringResource(id = stringResourceId),modifier=modifier, fontSize = 18.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LemonadeTheme {

    }
}