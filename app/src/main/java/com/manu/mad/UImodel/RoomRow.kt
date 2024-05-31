package com.manu.mad.UImodel

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun RoomRow(item: RoomRowModel) {
    var isExpanded by remember {
        mutableStateOf(false)
    }
    Row(
        modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = item.imageId),
            contentDescription = item.content,
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
                text = "${item.title} (${item.size} м. кв.)",
                style = TextStyle(fontWeight = FontWeight.Bold)
            )
            Text(
                modifier = Modifier.clickable {
                    isExpanded = !isExpanded
                },
                maxLines = if (isExpanded) 10 else 1,
                text = if (!isExpanded && item.content.length > 29) {
                    item.content.substring(0, 29) + "..."
                } else item.content
            )
        }
    }
}