package com.manu.mad.bottom_navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Build
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Star
import androidx.compose.ui.graphics.vector.ImageVector
import com.manu.mad.R

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
) {
    object RoomsScreen: BottomBarScreen(
        "rooms",
        "Rooms",
        Icons.Filled.Home,
        Icons.Outlined.Home,
    )
    object DevicesScreen: BottomBarScreen(
        "devices",
        "Devices",
        Icons.Filled.Build,
        Icons.Outlined.Build,
    )
    object ProfileScreen: BottomBarScreen(
        "profile",
        "Profile",
        Icons.Filled.Person,
        Icons.Outlined.Person,
    )
}