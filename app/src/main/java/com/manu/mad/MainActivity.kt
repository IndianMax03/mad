package com.manu.mad

import android.annotation.SuppressLint
import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.manu.mad.navigation.NavBarItems
import com.manu.mad.navigation.NavRoutes
import com.manu.mad.navigation.screens.DeviceCreationScreen
import com.manu.mad.navigation.screens.DevicesScreen
import com.manu.mad.navigation.screens.ProfileScreen
import com.manu.mad.navigation.screens.RoomsCreationScreen
import com.manu.mad.navigation.screens.RoomsScreen
import com.manu.mad.ui.theme.MadTheme
import com.manu.mad.viewModel.DeviceViewModel
import com.manu.mad.viewModel.DeviceViewModelFactory
import com.manu.mad.viewModel.RoomViewModel
import com.manu.mad.viewModel.RoomViewModelFactory

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val owner = LocalViewModelStoreOwner.current

            owner?.let {
                val roomViewModel: RoomViewModel = viewModel(
                    it,
                    "RoomViewModel",
                    RoomViewModelFactory(LocalContext.current.applicationContext as Application)
                )
                val deviceViewModel: DeviceViewModel = viewModel(
                    it,
                    "DeviceViewModel",
                    DeviceViewModelFactory(LocalContext.current.applicationContext as Application)
                )
                Main(roomViewModel, deviceViewModel)
            }
        }
    }
}

@Composable
fun Main(roomVm: RoomViewModel = viewModel(), deviceVm: DeviceViewModel = viewModel()) {
    val navController = rememberNavController()
    MadTheme {
        Column {
            NavHost(
                navController,
                startDestination = NavRoutes.RoomsScreen.route,
                modifier = Modifier.weight(1f)
            ) {
                composable(NavRoutes.RoomsScreen.route) { RoomsScreen(roomVm){ navController.navigate("roomCreation") } }
                composable("roomCreation") { RoomsCreationScreen(roomVm) {navController.navigate("rooms")} }
                composable(NavRoutes.DevicesScreen.route) { DevicesScreen(roomVm, deviceVm) {navController.navigate("deviceCreation")} }
                composable("deviceCreation") { DeviceCreationScreen(roomVm, deviceVm) {navController.navigate("devices")} }
                composable(NavRoutes.ProfileScreen.route) { ProfileScreen(deviceVm) }
            }
            BottomNavigationBar(navController = navController)
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    NavigationBar {
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route

        NavBarItems.barItems.forEach { navItem ->
            NavigationBarItem(
                selected = currentRoute == navItem.route,
                onClick = {
                    navController.navigate(navItem.route) {
                        popUpTo(id = navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(imageVector = navItem.image, contentDescription = navItem.title)
                },
                label = {
                    Text(text = navItem.title)
                }
            )
        }
    }
}
