package com.example.poryectofinal.CarpetaPantallaArticulos.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.poryectofinal.CarpetaPantallaArticulos.home.navigation.AppScreens
import com.example.poryectofinal.R

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Home(navController: NavController) {
    Scaffold {
        BodyContentHome(navController)
    }
}

@Composable
fun BodyContentHome(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Bienvenido a la pantalla de inicio",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Blue,
            modifier = Modifier
                .background(
                    Color.White,
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(14.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        Image(
            painter = painterResource(id = R.drawable.logo_pagina_inicio),
            contentDescription = null,
            modifier = Modifier
                .size(150.dp)
                .scale(1f),
            contentScale = ContentScale.FillBounds
        )

        Spacer(modifier = Modifier.height(0.dp))

        Text(
            text = "¡Bienvenidos a Lo Encontramos! En nuestro refugio, nos dedicamos con pasión a rescatar animales en situación de vulnerabilidad y ofrecerles el amor y cuidado que merecen. Te invitamos a conocer a nuestros adorables compañeros en busca de un hogar y a unirte a nuestra misión. Juntos podemos darles una segunda oportunidad y llenar sus vidas de alegría.\n" + "\n" +
                    "¡Haz clic ahora para sumergirte en el mundo de la ternura y la diversión animal! \uD83D\uDC3E",
            fontWeight = FontWeight.Bold,
            fontSize = 17.sp,
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
        )

        Spacer(modifier = Modifier.height(5.dp))

        //Botones para ir a pantallas

        Button(
            onClick = {
                navController.navigate(route = AppScreens.PantallaMascotasCatalogo.route)
            },

            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text(
                text = "Mascotas Perdidas y que puedes adoptar",
                fontWeight = FontWeight.Bold,
                fontSize = 19.sp,
            )
        }

        Button(
            onClick = {
                navController.navigate(route = AppScreens.PantallaAlimentosCatalogo.route)
            },
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text(
                text = "Alimentos",
                fontWeight = FontWeight.Bold,
                fontSize = 19.sp,
            )
        }

        Button(
            onClick = {
                navController.navigate(route = AppScreens.PantallaAccesoriosCatalogo.route)
            },
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text(
                text = "Accesorios",
                fontWeight = FontWeight.Bold,
                fontSize = 19.sp,
            )
        }
    }
}

