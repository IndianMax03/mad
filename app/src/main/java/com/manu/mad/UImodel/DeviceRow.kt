package com.manu.mad.UImodel

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.manu.mad.entity.Device
import com.manu.mad.viewModel.DeviceViewModel

@Composable
fun DeviceRow(item: DeviceRowModel, deviceVm: DeviceViewModel) {
    val devicesList by deviceVm.deviceList.observeAsState(listOf())
    Row(
        modifier = Modifier
            .padding(3.dp)
            .fillMaxSize()
            .drawBehind {
                val strokeWidth = 2 * density
                val y = size.height - strokeWidth / 2

                drawLine(
                    Color.LightGray,
                    Offset(0f, y),
                    Offset(size.width, y),
                    strokeWidth
                )
            }
    ) {
        Image(
            painter = painterResource(id = item.imageId),
            contentDescription = item.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(3.dp)
                .size(64.dp)
                .clip(CircleShape)
        )
        Column(
            modifier = Modifier
                .padding(start = 10.dp, top = 10.dp)
        ) {
            Text(
                text = "${item.title} в комнате '${item.roomName}'",
                style = TextStyle(fontWeight = FontWeight.Bold)
            )
            Text(
                text = "Потребляет ${item.voltage} кВт·ч"
            )
            Text(
                text = "Суммарная активность: ${item.uptime / 1000} сек "
            )

            var isActive by remember { mutableStateOf(item.isActive) }

            Switch(
                checked = isActive,
                onCheckedChange = {
                    isActive = !isActive
                    devicesList.find { device: Device -> device.id == item.deviceId }
                        ?.let { it1 ->
                            deviceVm.changeIsActive(it1)
                        }
                }
            )
        }
        Spacer(modifier = Modifier.size(10.dp))
        Icon(
            Icons.Filled.Clear,
            "Remove device",
            Modifier.clickable { deviceVm.deleteDevice(item.deviceId) })
    }
}