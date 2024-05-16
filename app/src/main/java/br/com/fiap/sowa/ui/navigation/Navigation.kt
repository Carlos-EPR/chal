package br.com.fiap.sowa.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.sowa.ui.screens.CadastroScreen
import br.com.fiap.sowa.ui.screens.MarchScreen
//import br.com.fiap.sowa.ui.screens.ConnectionsScreen
import br.com.fiap.sowa.ui.screens.HomeScreen
import br.com.fiap.sowa.ui.screens.LoginScreen
import br.com.fiap.sowa.ui.screens.PerfilScreen

@Composable
fun SetupNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        composable(route = "login") {
            LoginScreen(navController)
        }
        composable(route = "home") {
            HomeScreen(navController)
        }
        composable(route = "match") {
           MarchScreen(navController)
        }
        composable(route = "perfil") {
            PerfilScreen(navController, "")
        }
        composable(route = "cadastro") {
            CadastroScreen(navController)
        }
    }
}