package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

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
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun NameBox(modifier: Modifier = Modifier){
    val image = painterResource(id = R.drawable.img_20231124_121801)
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(painter = image, contentDescription = null, modifier = Modifier.size(200.dp))
        Text(text = "Egor Elovskiy", fontSize = 40.sp)
        Text(text = "Android developer", fontSize = 24.sp, color = Color(0xff176102))
    }
}

@Composable
fun ContactLine(str: String, icon: Int, modifier: Modifier = Modifier){
    Row (
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(painter = painterResource(icon), contentDescription = null, Modifier.size(19.dp))
        Text(text = str)
    }
}

@Composable
fun ContactBox(modifier: Modifier = Modifier){
    Column {
        ContactLine(str = "+7(909)578-40-36", icon = R.drawable.baseline_phone_black_24dp)
        ContactLine(str = "@SPB_Egor_Elovskiy", icon = R.drawable.baseline_share_black_24dp)
        ContactLine(str = "egor.elovskiyy@mail.ru", icon = R.drawable.baseline_email_black_24dp)
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
            .background(color = Color(0xff3acbe8))
    ) {
        Spacer(modifier = Modifier.height(200.dp))
        NameBox(Modifier.padding(16.dp))
        Spacer(modifier = Modifier.weight(1f))
        ContactBox(Modifier.padding(32.dp))
        Spacer(modifier = Modifier.weight(0.1f))
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}