package com.manu.mad.screens

import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.layout
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
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Мои комнаты",
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 12.dp),
            style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.ExtraBold)
        )
        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            itemsIndexed(
                listOf(
                    RoomRowModel(R.drawable.living_room, "Гостиная комната", "Гостиная комната для того, чтобы сидеть там кушать с друзьями, смотреть телек и чиллить"),
                    RoomRowModel(R.drawable.bath_room, "Ванная комната", "Ванна комната для того, чтобы подмываться и осуществлять еще много различных подпроцессий"),
                    RoomRowModel(R.drawable.kitchen_room, "Кухонная комната", "Кухня для того, чтобы чисто кушать, пить кофе и получать удовольствие"),
                    RoomRowModel(R.drawable.sleeping_room, "Спальная комната", "Спалья для того, чтобы спать, храпеть и прятать заначки от жены"),
                )
            ) {index, item ->
                RoomRow(item = item)
            }
        }
    }
}

