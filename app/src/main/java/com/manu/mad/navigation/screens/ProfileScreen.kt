package com.manu.mad.navigation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.manu.mad.R
import com.manu.mad.entity.Device
import com.manu.mad.ui.theme.Pink40
import com.manu.mad.ui.theme.Pink80
import com.manu.mad.ui.theme.Purple40
import com.manu.mad.ui.theme.Purple80
import com.manu.mad.ui.theme.PurpleGrey40
import com.manu.mad.viewModel.DeviceViewModel
import com.manu.mad.viewModel.RoomViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

@Composable
fun ProfileScreen(deviceVm: DeviceViewModel) {

    val devicesList by deviceVm.deviceList.observeAsState(listOf())

    val coroutineScope = rememberCoroutineScope()
    var isSimulatingPresence by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = isSimulatingPresence) {
        if (isSimulatingPresence) {
            while (coroutineScope.isActive) {
                coroutineScope.launch(Dispatchers.Main) {
                    val randDevice = devicesList.random()
                    deviceVm.changeIsActive(randDevice)
                }
                delay(1000)
            }
        }
    }


    Scaffold(
        topBar = {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Мой профиль",
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 12.dp),
                    style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.ExtraBold)
                )
            }

        },
        bottomBar = {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Row {
                    Button(
                        colors = ButtonDefaults.buttonColors(containerColor = Purple40),
                        onClick = {
                            isSimulatingPresence = false
                        }
                    ) {
                        Text(text = "Я дома")
                    }
                    Spacer(modifier = Modifier.size(30.dp))
                    Button(
                        colors = ButtonDefaults.buttonColors(containerColor = PurpleGrey40),
                        onClick = {
                            print("ОПАПА-КЛИК")
                            isSimulatingPresence = true
                        }
                    ) {
                        Text(text = "Воры!")
                    }
                }
            }
        },
    ) { it ->
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.avatar),
                contentDescription = "Максим",
                modifier = Modifier
                    .padding(top = 7.dp)
                    .size(256.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop,
            )
            Spacer(modifier = Modifier.size(15.dp))
            Text(
                text = "Максим Тучков",
                style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Bold)
            )
            Spacer(modifier = Modifier.size(25.dp))
            Text(text = "20 лет", style = TextStyle(fontSize = 20.sp))
            Spacer(modifier = Modifier.size(15.dp))
            Text(text = "Время работы = ${devicesList.sumOf { it.uptimeMs } / 1000} сек")
        }

    }


}
