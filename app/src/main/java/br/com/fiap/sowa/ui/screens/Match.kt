package br.com.fiap.sowa.ui.screens

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.sowa.R
import br.com.fiap.sowa.ui.components.Header
import br.com.fiap.sowa.ui.components.NavBar
import br.com.fiap.sowa.ui.components.CardPersonConnection
import br.com.fiap.sowa.ui.components.SearchBar

@Composable
fun MarchScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.superLightBlue))

    ) {
        Header()
        SearchBar()
        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            item {
                CardPersonConnection("Carlos Eduardo", "Física, Matemática", "SP", "carlos@email.com", "(11) 96371-4893")
                CardPersonConnection("David Bush", "História, Geografia", "BA", "carlos@email.com", "(11) 96371-4893")
                CardPersonConnection("Daniela Alameda", "Artes, Teatro", "RJ", "carlos@email.com", "(11) 96371-4893")
                CardPersonConnection("Thamirys Iris", "Artes Marciais, Dança", "CE", "carlos@email.com", "(11) 96371-4893")
                CardPersonConnection("João Vittor", "Espanhol, Inglês", "TO", "carlos@email.com", "(11) 96371-4893")
                CardPersonConnection("João Vittor", "Espanhol, Inglês", "TO", "carlos@email.com", "(11) 96371-4893")
              }
        }
        NavBar(navController, "match")
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewConnectionsScreen() {
    val navController = rememberNavController()
    Box(modifier = Modifier.fillMaxSize()) {
        MarchScreen(navController = navController)
    }
}
