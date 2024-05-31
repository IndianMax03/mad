package com.manu.mad.navigation

sealed class NavRoutes(val route: String) {

    object RoomsScreen : NavRoutes("rooms")
    object DevicesScreen : NavRoutes("devices")
    object ProfileScreen : NavRoutes("profile")

}
