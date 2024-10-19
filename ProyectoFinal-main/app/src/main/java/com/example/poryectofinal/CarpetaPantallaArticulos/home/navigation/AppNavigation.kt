package com.example.poryectofinal.CarpetaPantallaArticulos.home.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.poryectofinal.CarpetaPantallaArticulos.home.Home
import com.example.poryectofinal.CarpetaPantallaArticulos.home.PantallaMascotasCatalogo

@Composable
fun AppNavigation(pantallaMascotasCatalogo: AppScreens.PantallaMascotasCatalogo) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.MascotaHomeScreen.route){
        composable(route = AppScreens.MascotaHomeScreen.route){
            Home(navController)
        }
        composable(route = AppScreens.PantallaMascotasCatalogo.route){
            PantallaMascotasCatalogo(navController)
        }
    }
}