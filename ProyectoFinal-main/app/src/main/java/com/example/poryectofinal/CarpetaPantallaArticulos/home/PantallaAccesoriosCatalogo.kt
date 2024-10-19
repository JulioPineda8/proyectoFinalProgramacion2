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
fun PantallaAccesoriosCatalogo(navController: NavController) {
    Scaffold {
        BodyContentAccesorios(navController)
    }
}

@Composable
fun BodyContentAccesorios(navController: NavController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Text(
                text = "Catálogo de Accesorios",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }

        // Aquí estan todas las tarjetas para cada Accesorio
        item {
            AccesoriosCard(
                nombre = "Arnes Para Perro  Q120.00",
                imagenResId = R.drawable.arnes_easy_walk_petsafe_perro,
                descripcion = "Para que pueda llevar asu perro comodamente +" +
                        "sin lastimarlo"
            )
        }

        item {
            AccesoriosCard(
                nombre = "Cama Orthoconfort Q.63.00",
                imagenResId = R.drawable.cama_orthocomfort_smazonbasics_perro,
                descripcion = "Una bella cama comoda para su perro"
            )
        }

        item {
            AccesoriosCard(
                nombre = "Cepillo Slicker   Q.13.00",
                imagenResId = R.drawable.cepillo_slicker_hertzko_perro,
                descripcion = "Manten el cabello de tu perro adorable siempre"
            )
        }

        item {
            AccesoriosCard(
                nombre = "Collar Personalizado  Q.12.00",
                imagenResId = R.drawable.collar_personalizado_gotags_perro,
                descripcion = "Lucir a la moda con este collar elegante"
            )
        }

        item {
            AccesoriosCard(
                nombre = "Kong Clasico Para Perro   Q.5.00",
                imagenResId = R.drawable.kong_classic_dog_toy,
                descripcion = "Para entretener a su perro en todo lugar"
            )
        }

        item {
            AccesoriosCard(
                nombre = "Bebedero De Botella   Q.50.00",
                imagenResId = R.drawable.bebedero_de_botella_livingworldeco_hamster,
                descripcion = "Ecologio bebedero"
            )
        }

        item {
            AccesoriosCard(
                nombre = "Casita Moderna Para Hamster   Q.90.00",
                imagenResId = R.drawable.casita_de_hamster_niteangel_hamster,
                descripcion = "Bella casita para consetir las mascotas del hogar"
            )
        }

        item {
            AccesoriosCard(
                nombre = "Juguete De Madera Q.35.00",
                imagenResId = R.drawable.juguetes_de_madera_hamster,
                descripcion = "Juguete muy entretenido para su hamster"
            )
        }

        item {
            AccesoriosCard(
                nombre = "Rueda De Ejercicio    Q.12.00",
                imagenResId = R.drawable.rueda_de_ejercicio_kayteecomfort_hamster,
                descripcion = "Mantega siempre su mascota ejercitada con este producto"
            )
        }

        item {
            AccesoriosCard(
                nombre = "Tunel De Juego Para Hamster   Q.80.00",
                imagenResId = R.drawable.tunel_de_juego_kayteecrinkletunnel_hamster,
                descripcion = "Juguete adorable para su mascota consentida"
            )
        }

        item {
            AccesoriosCard(
                nombre = "Arbol Rascador Para Gato  Q.45.00",
                imagenResId = R.drawable.arbol_rascador_catitvesper_cubo_gato,
                descripcion = "Su gato ya no rascara con esas uñas su sofa con este increible producto"
            )
        }

        item {
            AccesoriosCard(
                nombre = "Cama Para Gato    Q.74.00",
                imagenResId = R.drawable.cama_catball_beds_gatos,
                descripcion = "Adorable cama para su mascota consentida"
            )
        }

        item {
            AccesoriosCard(
                nombre = "Fuente De Agua    Q.21.00",
                imagenResId = R.drawable.fuente_de_agua_catitflower_gatos,
                descripcion = "Mantega su mascota hidratada en todo momento"
            )
        }

        item {
            AccesoriosCard(
                nombre = "Juguete Interactivo   Q.25.00",
                imagenResId = R.drawable.juguete_interactivo_petstages_tower_of_tracks_gatos,
                descripcion = "Su mascota ya no pasara aburrida con este accesorio"
            )
        }

        item {
            AccesoriosCard(
                nombre = "Tunel Plegable Prosperpet Q.41.00",
                imagenResId = R.drawable.tunel_plegable_prosperpetcattunnel_gatos,
                descripcion = "Para los consentidos del hogar"
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
fun AccesoriosCard(nombre: String, imagenResId: Int, descripcion: String) {
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