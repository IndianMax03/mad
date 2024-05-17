package com.manu.mad.model

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun DeviceRow(item: DeviceRowModel) {
    Row(
        modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth()
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
            Text(text = item.title, style = TextStyle(fontWeight = FontWeight.Bold))
            Text(
                text = item.voltage.toString() + "кВт/ч"
            )
        }
    }
}