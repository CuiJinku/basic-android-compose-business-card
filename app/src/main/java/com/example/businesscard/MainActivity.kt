package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
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
                    BusinessCard(name = "Jennifer Doe")
                }
            }
        }
    }
}

@Composable
fun BusinessCard(name: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFD2E8D4)),
        contentAlignment = Alignment.Center,
    ) {
        val image = painterResource(id = R.drawable.android_logo)
        NameCard(
            logo = image,
            name = name,
            title = "Android Developer Extraordinaire"
        )
        ContactCard(
            phone = "+11 (123) 444 555 666",
            social = "@AndroidDev",
            email = "jen.doe@android.com",
            modifier = modifier.align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun NameCard(
    logo: Painter,
    name: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Column (
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = logo,
            contentDescription = null,
            modifier = modifier
                .fillMaxWidth(0.4f)
                .aspectRatio(1.0f)
                .background(Color(0xFF073042))
        )
        Text(
            text = name,
            fontSize = 48.sp,
            fontWeight = FontWeight.Light,
            modifier = modifier
                .padding(top = 12.dp)
        )
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF006327),
            modifier = modifier
                .padding(top=12.dp)
        )
    }
}

@Composable
fun ContactCard(
    phone: String,
    social: String,
    email: String,
    modifier: Modifier = Modifier
) {
    Column (
        modifier = modifier
            .padding(bottom = 32.dp),
    ) {
        Row (
            modifier = modifier
                .padding(8.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                Icons.Rounded.Phone,
                tint = Color(0xFF006D3B),
                contentDescription = "Contact Information"
            )
            Text(
                text = phone,
                modifier = modifier.padding(start = 16.dp),
            )
        }
        Row (
            modifier = modifier
                .padding(8.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                Icons.Rounded.Share,
                tint = Color(0xFF006D3B),
                contentDescription = "Contact Information"
            )
            Text(
                text = social,
                modifier = modifier.padding(start = 16.dp),
            )
        }
        Row (
            modifier = modifier
                .padding(8.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                Icons.Rounded.Email,
                tint = Color(0xFF006D3B),
                contentDescription = "Contact Information"
            )
            Text(
                text = email,
                modifier = modifier.padding(start = 16.dp),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCard(name = "Jennifer Doe")
    }
}