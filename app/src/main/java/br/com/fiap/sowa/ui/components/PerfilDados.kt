package br.com.fiap.sowa.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.sowa.R


@Composable
fun PerfilDados(telefone: String, email: String, endereco: String, descricao: String) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp)
            .padding(20.dp)
    ) {

        PerfilComponenteDado(text = "Telefone: ", dado = telefone)
        PerfilComponenteDado(text = "Email: ", dado = email)
        PerfilComponenteDado(text = "Endereço: ", dado = endereco)

        LazyColumn (
            modifier = Modifier.weight(1f)
        ) {
            item {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(0.dp, 12.dp, 0.dp, 12.dp),
                    shape = RoundedCornerShape(12.dp),
                    color = colorResource(id = R.color.lightGray2)
                )  {
                    Text(
                        text = descricao,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Light,
                        color = Color.Black,
                        modifier = Modifier .padding(14.dp)
                    )
                }
            }
        }
        Column {
            Text(
                text = "Áreas de interesse:",
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black,
            )
            Row {
                AreaInteresse(nomeAreaInteresse = "TEATRO", corAreaInteresse = Color.Red)
                AreaInteresse(nomeAreaInteresse = "DANCA", corAreaInteresse = Color.Blue)
                AreaInteresse(nomeAreaInteresse = "ROBOTICA", corAreaInteresse = Color.Gray)
                AreaInteresse(nomeAreaInteresse = "CIENCIA", corAreaInteresse = Color.Cyan)
            }
        }
    }
}