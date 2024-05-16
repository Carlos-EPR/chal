package br.com.fiap.sowa.ui.screens
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import br.com.fiap.sowa.ui.components.GradientHeaderWithImage
import br.com.fiap.sowa.ui.components.LoginAndCadastro
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import br.com.fiap.sowa.ui.components.FooterLogin
import br.com.fiap.sowa.ui.components.FormCadastro

@Composable
fun CadastroScreen(navController: NavController) {
    Column (
        modifier = Modifier.fillMaxSize()
    ){
        GradientHeaderWithImage()
        LoginAndCadastro(navController)
        LazyColumn(
        ) {
            item {
                FormCadastro(navController)
                FooterLogin()

            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewCadastroScreen() {
    val navController = rememberNavController()
    Box(modifier = Modifier.fillMaxSize()) {
        CadastroScreen(navController = navController)
    }
}