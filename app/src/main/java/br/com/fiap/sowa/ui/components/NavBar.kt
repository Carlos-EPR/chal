package br.com.fiap.sowa.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import br.com.fiap.sowa.R

@Composable
fun NavBar(navController: NavController, perfilButton: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .background(colorResource(id = R.color.bluePrincipal)),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            onClick = { navController.navigate("home") },
            colors = ButtonDefaults.buttonColors(if (perfilButton == "home") colorResource(id = R.color.darkBlue) else colorResource(id = R.color.bluePrincipal)),
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(1f)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.home),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(30.dp)
                )
                Spacer(modifier = Modifier.height(3.dp))
                Text(text = "Home", fontSize = 12.sp, color = Color.White)
            }
        }
        Button(
            onClick = { navController.navigate("match") },
            colors = ButtonDefaults.buttonColors(if (perfilButton == "match") colorResource(id = R.color.darkBlue) else colorResource(id = R.color.bluePrincipal)),
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(1f)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.connection),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(30.dp)
                )
                Spacer(modifier = Modifier.height(3.dp))
                Text(text = "Matchs", fontSize = 12.sp, color = Color.White)
            }
        }

        Button(
            onClick = { navController.navigate("perfil") },
            colors = ButtonDefaults.buttonColors(if (perfilButton == "perfil") colorResource(id = R.color.darkBlue) else colorResource(id = R.color.bluePrincipal)),
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(1f)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.perfil),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(30.dp)
                )
                Spacer(modifier = Modifier.height(3.dp))
                Text(text = "Perfil", fontSize = 12.sp, color = Color.White)
            }
        }
    }
}


