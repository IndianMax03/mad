package com.manu.mad.navigation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.manu.mad.enums.DeviceType
import com.manu.mad.enums.RoomType
import com.manu.mad.ui.theme.Pink40
import com.manu.mad.ui.theme.Purple40
import com.manu.mad.viewModel.DeviceViewModel
import com.manu.mad.viewModel.RoomViewModel

@Composable
fun DeviceCreationScreen(roomVm: RoomViewModel, deviceVm: DeviceViewModel, goBack: () -> Unit) {

    val roomList by roomVm.roomList.observeAsState(listOf())

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
            text = "Добавление девайса",
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 12.dp),
            style = TextStyle(fontSize = 25.sp, fontWeight = FontWeight.ExtraBold),
        )

        OutlinedTextField(
            value = deviceVm.deviceName,
            modifier = Modifier.padding(8.dp),
            label = { Text("Название") },
            onValueChange = { deviceVm.changeName(it) }
        )

        Spacer(modifier = Modifier.size(35.dp))

        var typeExpanded by remember { mutableStateOf(false) }
        val typeIcon = if (typeExpanded)
            Icons.Filled.KeyboardArrowUp
        else
            Icons.Filled.KeyboardArrowDown

        Column(Modifier.padding(5.dp)) {
            OutlinedTextField(
                value = deviceVm.deviceType.title,
                onValueChange = { },
                modifier = Modifier
                    .fillMaxWidth(),
                label = { Text(fontSize = 16.sp, text = "Тип") },
                trailingIcon = {
                    Icon(typeIcon, "",
                        Modifier.clickable { typeExpanded = !typeExpanded })
                }
            )
            DropdownMenu(
                expanded = typeExpanded,
                onDismissRequest = { typeExpanded = false }
            ) {
                DeviceType.entries.forEach { element ->
                    DropdownMenuItem(
                        text = { Text(text = element.title) },
                        onClick = {
                            deviceVm.changeType(element)
                            typeExpanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.size(50.dp))

        OutlinedTextField(
            value = deviceVm.deviceVoltage.toString(),
            modifier = Modifier.padding(8.dp),
            label = { Text("Потребление, кВт·ч") },
            onValueChange = { deviceVm.changeVoltage(it.toDouble()) },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )

        Spacer(modifier = Modifier.size(50.dp))

        var roomExpanded by remember { mutableStateOf(false) }
        val roomIcon = if (roomExpanded)
            Icons.Filled.KeyboardArrowUp
        else
            Icons.Filled.KeyboardArrowDown

        Column(Modifier.padding(5.dp)) {
            OutlinedTextField(
                value = deviceVm.roomId.toString(),
                onValueChange = { },
                modifier = Modifier
                    .fillMaxWidth(),
                label = { Text(fontSize = 16.sp, text = "Комната") },
                trailingIcon = {
                    Icon(typeIcon, "",
                        Modifier.clickable { roomExpanded = !roomExpanded })
                }
            )
            DropdownMenu(
                expanded = roomExpanded,
                onDismissRequest = { roomExpanded = false }
            ) {
                roomList.forEach { element ->
                    DropdownMenuItem(
                        text = { Text(text = element.name) },
                        onClick = {
                            deviceVm.changeRoomId(element.id)
                            roomExpanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.size(50.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                colors = ButtonDefaults.buttonColors(containerColor = Pink40),
                onClick = { goBack() },
            ) {
                Text(text = "Вернуться")
            }
            Spacer(modifier = Modifier.size(30.dp))
            Button(
                colors = ButtonDefaults.buttonColors(containerColor = Purple40),
                onClick = {
                    deviceVm.addDevice()
                    goBack()
                }) {
                Text(text = "Создать")
            }
        }

    }

}
