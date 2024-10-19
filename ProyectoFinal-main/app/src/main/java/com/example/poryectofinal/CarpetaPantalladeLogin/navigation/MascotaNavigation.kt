package com.example.poryectofinal.CarpetaPantalladeLogin.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.poryectofinal.CarpetaPantallaArticulos.home.Home
import com.example.poryectofinal.CarpetaPantallaArticulos.home.PantallaAccesoriosCatalogo
import com.example.poryectofinal.CarpetaPantallaArticulos.home.PantallaAlimentosCatalogo
import com.example.poryectofinal.CarpetaPantallaArticulos.home.PantallaMascotasCatalogo
import com.example.poryectofinal.CarpetaPantallaArticulos.home.navigation.AppScreens
import com.example.poryectofinal.CarpetaPantalladeLogin.navigation.screens.MascotaSplashScreen
import com.example.poryectofinal.CarpetaPantalladeLogin.navigation.screens.login.MascotaLoginScreen

@Composable
fun   MascotaNavigation(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MascotaScreens.SplashScreen.name
    ){
        composable(MascotaScreens.SplashScreen.name){
            MascotaSplashScreen(navController = navController)
        }
        composable(MascotaScreens.LoginScreen.name){
            MascotaLoginScreen(navController = navController)
        }

        //pantallas pe
        composable(MascotaScreens.MascotaHomeScreen.name){
            Home(navController = navController)
        }
        composable(route = AppScreens.MascotaHomeScreen.route){
            Home(navController)
        }
        composable(route = AppScreens.PantallaMascotasCatalogo.route){
            PantallaMascotasCatalogo(navController)
        }
        composable(route = AppScreens.PantallaAlimentosCatalogo.route){
            PantallaAlimentosCatalogo(navController)
        }
        composable(route = AppScreens.PantallaAccesoriosCatalogo.route){
            PantallaAccesoriosCatalogo(navController)
        }
    }
}