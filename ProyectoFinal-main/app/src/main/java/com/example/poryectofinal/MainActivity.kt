package com.example.poryectofinal

import android.os.Bundle
import android.support.v4.os.IResultReceiver2.Default
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.poryectofinal.CarpetaPantallaArticulos.home.Home
import com.example.poryectofinal.CarpetaPantallaArticulos.home.navigation.AppNavigation
import com.example.poryectofinal.CarpetaPantalladeLogin.navigation.MascotaNavigation
import com.example.poryectofinal.ui.theme.PoryectoFinalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PoryectoFinalTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MascotaApp()

                }
            }
        }
    }
}


@Composable
fun MascotaApp(){
    Surface(modifier = Modifier
        .fillMaxSize()
        .padding(top = 46.dp),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MascotaNavigation()
        }
    }
}




