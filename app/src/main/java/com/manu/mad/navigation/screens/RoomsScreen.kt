package com.manu.mad.navigation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.manu.mad.UImodel.RoomRow
import com.manu.mad.UImodel.RoomRowModel
import com.manu.mad.enums.getRoomImageId
import com.manu.mad.viewModel.RoomViewModel

@Composable
fun RoomsScreen(vm: RoomViewModel = viewModel(), onCreateRoom: () -> Unit) {
    val roomList by vm.roomList.observeAsState(listOf())

    Scaffold(
        topBar = {},
        floatingActionButton = {
            FloatingActionButton(
                content = { Icon(Icons.Filled.Add, contentDescription = "Добавить") },
                onClick = { onCreateRoom() }
            )
        },
        floatingActionButtonPosition = FabPosition.End
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(it),
        ) {
            Text(
                text = "Мои комнаты",
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 12.dp),
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.ExtraBold)
            )
            LazyColumn(
                modifier = Modifier.fillMaxWidth()
            ) {
                items(roomList) { room ->
                    RoomRow(
                        item = RoomRowModel(
                            getRoomImageId(room.roomType),
                            room.name,
                            room.description,
                            room.sizeSqM
                        )
                    )
                }
            }
        }
    }
}

