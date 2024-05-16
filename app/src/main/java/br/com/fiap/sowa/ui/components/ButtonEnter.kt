package br.com.fiap.sowa.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ButtonEnter(navController: NavController) {
    Button(
        onClick = { navController.navigate("home") },
        colors = ButtonDefaults.buttonColors(Color.Transparent),
        modifier = Modifier
            .width(270.dp)
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(Color(0xFF3A7CCB), Color(0xFF1A4980)),
                    startX = 0f,
                    endX = 900f
                ),
                shape = RoundedCornerShape(10.dp)
            )
    ) {
        Text(
            text = "ENTRAR",
            fontSize = 16.sp,
            color = Color.White
        )
    }
}