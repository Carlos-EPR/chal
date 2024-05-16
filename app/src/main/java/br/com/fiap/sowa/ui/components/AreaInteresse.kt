package br.com.fiap.sowa.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AreaInteresse(
    nomeAreaInteresse: String,
    corAreaInteresse: Color
) {
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(corAreaInteresse),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .height(30.dp)
            .padding(0.dp, 0.dp, 5.dp, 0.dp)
    ) {
        Text(text = "#$nomeAreaInteresse", fontSize = 10.sp, color = Color.White, fontWeight = FontWeight.Medium)
    }
}