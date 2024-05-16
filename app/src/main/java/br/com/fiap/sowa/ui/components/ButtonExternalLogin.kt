package br.com.fiap.sowa.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.sowa.R

@Composable
fun ExternalLoginButtons() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding
                (vertical = 8.dp, horizontal = 60.dp)
    ) {
        Divider(modifier = Modifier.weight(1f), color = Color.Gray)
        Text(
            text = "OU",
            color = Color.Gray,
            fontSize = 12.sp,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Divider(modifier = Modifier.weight(1f), color = Color.Gray)
    }

    Spacer(modifier = Modifier.height(8.dp))

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        SocialButton(
            icon = R.drawable.google_icon,
            text = "Entrar com Google"
        )

        Spacer(modifier = Modifier.height(12.dp))

        SocialButton(
            icon = R.drawable.facebook_icon,
            text = "Entrar com Facebook"
        )
    }
}