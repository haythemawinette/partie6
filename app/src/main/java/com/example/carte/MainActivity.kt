package com.example.carte

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.carte.ui.theme.CarteTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CarteTheme {
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
fun BusinessCard() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = "Logo Android",
            modifier = Modifier.size(128.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))


        Text(text = "Haythem Aouinette", color = Color(0xFF3DDC84), style = MaterialTheme.typography.headlineMedium)
        Text(text = "Développeur Android", style = MaterialTheme.typography.bodyLarge)

        Spacer(modifier = Modifier.height(32.dp))


        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            ContactInfoRow(
                iconResId = R.drawable.phone_24dp_5f6368,
                contentDescription = "Icône téléphone",
                contactText = "+27 668 409"
            )

            Spacer(modifier = Modifier.height(16.dp))

            ContactInfoRow(
                iconResId = R.drawable.email_24dp_5f6368,
                contentDescription = "Icône courriel",
                contactText = "Haythem.doe@example.com"
            )

            Spacer(modifier = Modifier.height(16.dp))

            ContactInfoRow(
                iconResId = R.drawable.share_24dp_5f6368,
                contentDescription = "Icône de partage",
                contactText = "123, Avenue de Hawaria"
            )
        }
    }
}

@Composable
fun ContactInfoRow(iconResId: Int, contentDescription: String, contactText: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        ContactIcon(iconResId = iconResId, contentDescription = contentDescription)
        Text(text = contactText, modifier = Modifier.align(Alignment.CenterVertically))
    }
}

@Composable
fun ContactIcon(iconResId: Int, contentDescription: String) {
    Image(
        painter = painterResource(id = iconResId),
        contentDescription = contentDescription,
        modifier = Modifier.size(48.dp),
        contentScale = ContentScale.Fit
    )
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    CarteTheme {
        BusinessCard()
    }
}
