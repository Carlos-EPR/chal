package br.com.fiap.sowa.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.sowa.R

@Composable
fun PerfilHeader(nome: String, areas: String, avaliacao: String, numbConnections: String) {
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .height(230.dp)
            .shadow(6.dp)
            .background(
                brush = androidx.compose.ui.graphics.Brush.horizontalGradient(
                    colors = listOf(Color(0xFF3A7CCB), Color(0xFF1A4980)),
                    startX = 0f,
                    endX = 900f
                )
            )
    ){
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .height(180.dp)
        ){
            Button(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(50.dp),
                colors = ButtonDefaults.buttonColors(Color.White),
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.person),
                    contentDescription = "Ícone de pessoa",
                    tint = Color.Black,
                    modifier = Modifier.size(90.dp)
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = nome,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold ,
                color = Color.White
            )
            Text(
                text = areas,
                fontSize = 13.sp,
                fontWeight = FontWeight.Light,
                color = Color.White
            )
        }
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(colorResource(id = R.color.darkBlue)),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ){
            PerfilHeaderDados(
                descricao = "Ícone de avaliação",
                iconId = R.drawable.baseline_star_24,
                color = Color.Yellow,
                texto = avaliacao
            )
            PerfilHeaderDados(
                descricao = "Ícone de connects",
                iconId = R.drawable.connect,
                color = Color.White,
                texto = numbConnections
            )
            PerfilHeaderDados(
                descricao = "Ícone de configurações",
                iconId = R.drawable.baseline_settings_24,
                color = Color.White,
                texto = "Editar perfil"
            )
        }
    }
}