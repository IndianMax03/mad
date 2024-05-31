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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
import androidx.navigation.NavController
import com.manu.mad.enums.RoomType
import com.manu.mad.ui.theme.Pink40
import com.manu.mad.ui.theme.Purple40
import com.manu.mad.viewModel.RoomViewModel
import kotlin.math.roundToInt

@Composable
fun RoomsCreationScreen(vm: RoomViewModel, goBack: () -> Unit) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
            text = "Добавление комнаты",
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 12.dp),
            style = TextStyle(fontSize = 25.sp, fontWeight = FontWeight.ExtraBold),
        )

        OutlinedTextField(
            value = vm.roomName,
            modifier = Modifier.padding(8.dp),
            label = { Text("Название") },
            onValueChange = { vm.changeName(it) }
        )

        OutlinedTextField(
            value = vm.roomDescription,
            modifier = Modifier.padding(8.dp),
            label = { Text("Описание") },
            onValueChange = { vm.changeDescription(it) }
        )

        Spacer(modifier = Modifier.size(35.dp))

        Text(
            modifier = Modifier.padding(8.dp),
            text = "Размер = ${vm.roomSize} м^2",
        )
        Slider(
            value = vm.roomSize,
            modifier = Modifier
                .padding(horizontal = 60.dp, vertical = 8.dp)
                .size(width = 270.dp, height = 12.dp),
            onValueChange = { vm.changeRoomSize(it) },
            valueRange = 0f..50f,
            steps = 20,
            colors = SliderDefaults.colors(
                activeTrackColor = Color.Blue,
            ),
        )

        Spacer(modifier = Modifier.size(35.dp))

        var expanded by remember { mutableStateOf(false) }
        val icon = if (expanded)
            Icons.Filled.KeyboardArrowUp
        else
            Icons.Filled.KeyboardArrowDown

        Column(Modifier.padding(5.dp)) {
            OutlinedTextField(
                value = vm.roomType.title,
                onValueChange = { },
                modifier = Modifier
                    .fillMaxWidth(),
                label = { Text(fontSize = 16.sp, text = "Тип") },
                trailingIcon = {
                    Icon(icon, "",
                        Modifier.clickable { expanded = !expanded })
                }
            )
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                RoomType.entries.forEach { element ->
                    DropdownMenuItem(
                        text = { Text(text = element.title) },
                        onClick = {
                            vm.changeRoomType(element)
                            expanded = false
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
                    vm.addRoom()
                    goBack()
                }) {
                Text(text = "Создать")
            }
        }

    }

}