package com.manu.mad.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.manu.mad.R

@Composable
fun ProfileScreen() {
    var amount by remember {
        mutableStateOf(20000)
    }
    var fine by remember {
        mutableStateOf(5392)
    }
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.funny_man),
            contentDescription = "Максим",
            modifier = Modifier
                .padding(top = 7.dp)
                .size(256.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop,
        )
        Spacer(modifier = Modifier.size(15.dp))
        Text(text = "Максим Тучков", style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Bold))
        Spacer(modifier = Modifier.size(25.dp))
        Text(text = "20 лет", style = TextStyle(fontSize = 20.sp))
        Spacer(modifier = Modifier.size(15.dp))
        Text(text = "Баланс: $amount ₽", style = TextStyle(fontSize = 20.sp))
        Spacer(modifier = Modifier.size(15.dp))
        Text(text = "Потребляется: 1.332 кВт/ч", style = TextStyle(fontSize = 20.sp))
        Spacer(modifier = Modifier.size(15.dp))
        Text(text = "Задолженность: $fine ₽", style = TextStyle(fontSize = 20.sp))
        Spacer(modifier = Modifier.size(15.dp))
        ElevatedButton(
            onClick = {
                amount -= fine
                fine = 0
            }
        ) {
            Text("Погасить")
        }

    }
}