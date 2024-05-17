package com.manu.mad.bottom_navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.manu.mad.screens.DevicesScreen
import com.manu.mad.screens.ProfileScreen
import com.manu.mad.screens.RoomsScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = BottomBarScreen.RoomsScreen.route) {
        composable(route = BottomBarScreen.RoomsScreen.route) {
            RoomsScreen()
        }
        composable(route = BottomBarScreen.DevicesScreen.route) {
            DevicesScreen()
        }
        composable(route = BottomBarScreen.ProfileScreen.route) {
            ProfileScreen()
        }
    }

}