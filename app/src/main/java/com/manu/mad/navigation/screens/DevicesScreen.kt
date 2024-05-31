package com.manu.mad.navigation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.manu.mad.R
import com.manu.mad.UImodel.DeviceRow
import com.manu.mad.UImodel.DeviceRowModel
import com.manu.mad.enums.getDeviceImageId
import com.manu.mad.viewModel.DeviceViewModel
import com.manu.mad.viewModel.RoomViewModel

@Composable
fun DevicesScreen(roomVm: RoomViewModel, deviceVm: DeviceViewModel, onCreateDevice: () -> Unit) {

    val devicesList by deviceVm.deviceList.observeAsState(listOf())
    val roomList by roomVm.roomList.observeAsState(listOf())

    Scaffold(
        topBar = {},
        floatingActionButton = {
            if (roomList.isNotEmpty()) {
                FloatingActionButton(
                    content = { Icon(Icons.Filled.Add, contentDescription = "Добавить") },
                    onClick = { onCreateDevice() },
                )
            }
        },
        floatingActionButtonPosition = FabPosition.End
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
        ) {
            Text(
                text = "Мои девайсы",
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 12.dp),
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.ExtraBold)
            )
            LazyColumn(
                modifier = Modifier.fillMaxWidth()
            ) {
                items(devicesList) { device ->
                    val targetRoomName: String = roomList.find { it.id == device.roomId }!!.name
                    DeviceRow(
                        DeviceRowModel(
                            device.id,
                            getDeviceImageId(device.deviceType),
                            device.name,
                            device.isActive,
                            device.voltage,
                            device.uptimeMs,
                            targetRoomName
                        ), deviceVm
                    )
                }
            }
        }
    }
}
