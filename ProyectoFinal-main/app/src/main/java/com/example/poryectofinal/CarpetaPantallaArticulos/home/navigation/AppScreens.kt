package com.example.poryectofinal.CarpetaPantallaArticulos.home.navigation

sealed class AppScreens(val route: String){
    object MascotaHomeScreen: AppScreens("mascota_home_screen")
    object PantallaMascotasCatalogo: AppScreens("pantalla_mascotas_catalogo")
    object PantallaAlimentosCatalogo: AppScreens("pantalla_alimentos_catalogo")
    object PantallaAccesoriosCatalogo: AppScreens("pantalla_accesorios_catalogo")
}
