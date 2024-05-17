package com.manu.mad.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.manu.mad.R
import com.manu.mad.model.DeviceRow
import com.manu.mad.model.DeviceRowModel

@Composable
fun DevicesScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Мои девайсы",
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 12.dp),
            style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.ExtraBold)
        )
        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            itemsIndexed(
                listOf(
                    DeviceRowModel(R.drawable.robot_dust_sucker, "Робот-пылесос", 1.2),
                    DeviceRowModel(R.drawable.music_station, "Музыкальная станция", 0.065),
                    DeviceRowModel(R.drawable.smart_lamp, "Умная лампочка", 0.06),
                    DeviceRowModel(R.drawable.smart_garage, "Умный гараж", 0.007),
                )
            ) {index, item ->
                DeviceRow(item = item)
            }
        }
    }
}