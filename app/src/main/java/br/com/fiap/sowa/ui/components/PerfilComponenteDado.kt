package br.com.fiap.sowa.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PerfilComponenteDado(
    text: String,
    dado: String
) {
    Row {
        Text(
            text = text,
            fontSize = 15.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Black
        )
        Spacer(modifier = Modifier.width(6.dp))
        Text(
            text = dado,
            fontSize = 13.sp,
            fontWeight = FontWeight.Light,
            color = Color.Black
        )
    }
    Spacer(modifier = Modifier.height(6.dp))
}