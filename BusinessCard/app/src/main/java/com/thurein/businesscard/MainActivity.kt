package com.thurein.businesscard

import androidx.compose.material.icons.Icons
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thurein.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BussinessCard()
                }
            }
        }
    }
}



@Composable
fun BussinessCard(modifier: Modifier= Modifier){
    Column(modifier = Modifier.background(Color.LightGray),Arrangement.SpaceBetween,Alignment.CenterHorizontally,) {
        PersonInformation("Thurein Tun", jobTitle = "Mobile Developer")
        ContactInformation(phone = "+9590000000", social ="@thurein" , email ="thurein@gmail.com" )
    }
}

@Composable
fun PersonInformation (name:String,jobTitle:String,modifier: Modifier=Modifier){
    val image = painterResource(id = R.drawable.android_logo)

    Column(modifier = modifier.padding(top = 250.dp), horizontalAlignment = Alignment.CenterHorizontally) {

        Image(painter = image, contentDescription = "Android Logo",
            modifier=Modifier.background(
            Color.Black)
                .size(150.dp)
        )
        Text(text = name, modifier = modifier.padding(10.dp), fontSize = 48.sp, fontWeight = FontWeight.Bold)
        Text(text = jobTitle,modifier=modifier, color = Color(0xFF3ddc84))

    }
}

@Composable
fun Information(value:String, icon: ImageVector,modifier: Modifier=Modifier){
    Row(modifier = Modifier.padding(10.dp
    )) {
        Icon(icon, contentDescription = "phone", tint = Color(0xFF3ddc84))
        Text(text = value,modifier=Modifier.padding(start = 10.dp) )
    }
}
@Composable
fun ContactInformation (phone:String,social:String,email:String,modifier: Modifier=Modifier){
    Column (modifier = modifier.padding(bottom = 50.dp)){
        Information(value = phone, icon = Icons.Rounded.Phone)
        Information(value = social, icon = Icons.Rounded.Share)
        Information(value = email, icon = Icons.Rounded.Email,)
    }

}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BussinessCard()
    }
}