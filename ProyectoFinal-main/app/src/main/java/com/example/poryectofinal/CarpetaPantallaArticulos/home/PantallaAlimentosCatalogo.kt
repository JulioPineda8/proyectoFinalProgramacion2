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
import androidx.compose.foundation.lazy.LazyColumn
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

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PantallaAlimentosCatalogo(navController: NavController) {
    Scaffold {
        BodyContentAlimentos(navController)
    }
}

@Composable
fun BodyContentAlimentos(navController: NavController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Text(
                text = "Catálogo de Comida",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }

        // Aquí estan todas las tarjetas para cada comida de las mascotas
        item {
            ComidaCard(
                nombre = "Super Cat     Q.350.20",
                imagenResId = R.drawable.comida_supercat_gato,
                descripcion = "Croquetas para mantener siempre feliz asu gato"
            )
        }

        item {
            ComidaCard(
                nombre = "Ganador       Q120.00",
                imagenResId = R.drawable.comida_ganador_perro,
                descripcion = "Comida especial y nutritiva para su mascota "
            )
        }

        item {
            ComidaCard(
                nombre = "Brit Animals      Q.310.00",
                imagenResId = R.drawable.comida_britanimals_hamster,
                descripcion = "Mantener siempre alimentado su mascota este producto es el mejor"
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
fun ComidaCard(nombre: String, imagenResId: Int, descripcion: String) {
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
                    .height(250.dp)
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