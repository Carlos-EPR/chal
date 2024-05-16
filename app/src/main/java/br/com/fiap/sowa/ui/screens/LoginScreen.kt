package br.com.fiap.sowa.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.sowa.ui.components.ButtonEnter
import br.com.fiap.sowa.ui.components.EmailAndPasswordFields
import br.com.fiap.sowa.ui.components.GradientHeaderWithImage
import br.com.fiap.sowa.ui.components.LoginAndCadastro
import br.com.fiap.sowa.ui.components.ExternalLoginButtons
import br.com.fiap.sowa.ui.components.FooterLogin

@Composable
fun LoginScreen(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            GradientHeaderWithImage()
            LoginAndCadastro(navController)
            Spacer(modifier = Modifier.height(16.dp))
            EmailAndPasswordFields(navController)
            Spacer(modifier = Modifier.height(16.dp))
            ButtonEnter(navController)
            Spacer(modifier = Modifier.height(16.dp))
            ExternalLoginButtons()
            Spacer(modifier = Modifier.weight(1f))
            FooterLogin()
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewLoginScreen() {
    val navController = rememberNavController()
    Box(modifier = Modifier.fillMaxSize()) {
        LoginScreen(navController = navController)
    }
}