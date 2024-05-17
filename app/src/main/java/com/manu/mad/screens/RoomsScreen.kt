package com.manu.mad.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.manu.mad.R
import com.manu.mad.model.RoomRow
import com.manu.mad.model.RoomRowModel

@Preview()
@Composable
fun RoomsScreen() {
    Column {
        Text(
            text = "Мои комнаты",
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 12.dp),
            style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.ExtraBold)
        )
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            itemsIndexed(
                listOf(
                    RoomRowModel(R.drawable.living_room, "Living room", "Гостиная sdlfk hjslkd fjsld kfjslk dfjs kldfjslkdfjslkdfjs lkdfjlskdfjlskdjflksdfjlks"),
                    RoomRowModel(R.drawable.living_room, "Living room", "Гостиная"),
                    RoomRowModel(R.drawable.living_room, "Living room", "Гостиная"),
                    RoomRowModel(R.drawable.living_room, "Living room", "Гостиная"),
                )
            ) {index, item ->
                RoomRow(item = item)
            }
        }
    }
}

