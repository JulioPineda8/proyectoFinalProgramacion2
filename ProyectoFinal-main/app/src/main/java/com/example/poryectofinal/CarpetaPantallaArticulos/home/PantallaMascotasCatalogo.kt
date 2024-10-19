package com.example.poryectofinal.CarpetaPantallaArticulos.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.poryectofinal.R
import androidx.compose.foundation.lazy.LazyColumn

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PantallaMascotasCatalogo(navController: NavController) {
    Scaffold {
        BodyContentMascotas(navController)
    }
}

@Composable
fun BodyContentMascotas(navController: NavController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Text(
                text = "Mascotas Perdidas",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }

        // Aquí estan todas las tarjetas para cada mascota
        item {
            MascotaCard(
                nombre = "Sparky",
                imagenResId = R.drawable.beagle_perro,
                descripcion = "Raza Beagle encontrado hace 1 semana"
            )
        }
        item {
            MascotaCard(
                nombre = "Gary",
                imagenResId = R.drawable.bulldog_frances_perro,
                descripcion = "Raza Bulldog encontrado hace 1 mes"
            )
        }
        item {
            MascotaCard(
                nombre = "Furia",
                imagenResId = R.drawable.doberman_perro,
                descripcion = " Raza Doberman encontrado en Jutiapa hace 1 semana"
            )
        }
        item {
            MascotaCard(
                nombre = "Muchacho",
                imagenResId = R.drawable.labrador_retriever_perro,
                descripcion = "Raza Labrador rescatado en un derrumbe en pinula"
            )
        }
        item {
            MascotaCard(
                nombre = "Julio",
                imagenResId = R.drawable.pastor_aleman_perro,
                descripcion = "Raza Pastor Aleman, abandonado y rescatado"
            )
        }



        item {
            MascotaCard(
                nombre = "Wilson",
                imagenResId = R.drawable.gato_bengali_gato,
                descripcion = "Encontrado hace un mes, Raza bengali"
            )
        }

        item {
            MascotaCard(
                nombre = "Peligro",
                imagenResId = R.drawable.gato_maine_coon_gato,
                descripcion = "Abandonado en pinula hace 3 meses"
            )
        }

        item {
            MascotaCard(
                nombre = "Bills",
                imagenResId = R.drawable.gato_persa_gato,
                descripcion = "Rescatado hace 2 meses en el departamento de jutiapa"
            )
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }

        // Botón para volver atrás
        item {
            Button(onClick = { navController.popBackStack() }) {
                Text(text = "Volver Atrás")
            }
        }
    }
}

@Composable
fun MascotaCard(nombre: String, imagenResId: Int, descripcion: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
    ) {
        Column(
            modifier = Modifier.clickable { /* Puedes agregar lógica de clic aquí si es necesario */ }
        ) {
            Image(
                painter = painterResource(id = imagenResId),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(230.dp)
            )

            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = nombre,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 4.dp)
                )

                Text(text = descripcion)
            }
        }
    }
}

