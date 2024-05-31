package com.manu.mad.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person

object NavBarItems {

    val barItems = listOf(
        BarItem(
            title = "Комнаты",
            image = Icons.Filled.Home,
            route = "rooms"
        ),
        BarItem(
            title = "Девайсы",
            image = Icons.Filled.Build,
            route = "devices"
        ),
        BarItem(
            title = "Профиль",
            image = Icons.Filled.Person,
            route = "profile"
        )
    )

}