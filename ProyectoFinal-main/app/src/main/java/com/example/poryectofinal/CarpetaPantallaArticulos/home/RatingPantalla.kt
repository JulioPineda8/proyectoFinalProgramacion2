package com.example.poryectofinal.CarpetaPantallaArticulos.home


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ratingcompose.ui.theme.RatingComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RatingComposeTheme {
                // Llama a la página simplificada
                RatingPantalla()
            }
        }
    }
}

@Composable
fun RatingPantalla() {
    // Página básica con solo texto
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Bienvenido a RatingPantalla")
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Esta es una página sencilla")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RatingComposeTheme {
        RatingPantalla()
    }
}