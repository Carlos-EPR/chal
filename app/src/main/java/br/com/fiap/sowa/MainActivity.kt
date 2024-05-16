package br.com.fiap.sowa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import br.com.fiap.sowa.ui.navigation.SetupNavigation

import br.com.fiap.sowa.ui.theme.SowaTheme


class MainActivity : ComponentActivity() {
    //@OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SowaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SetupNavigation()
                }
            }
        }
    }
}




































/*

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SowaTheme {
        Greeting("Android")
    }
}


package br.com.fiap.sowa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.*
import androidx.navigation.NavHost
import androidx.navigation.*
////import androidx.navigation.compose.NavHost
////import androidx.navigation.compose.rememberNavController
//import com.google.accompanist.navigation.animation.composable
////import androidx.navigation.compose.composable

import androidx.navigation.compose.*
import br.com.fiap.sowa.screens.*
import br.com.fiap.sowa.ui.theme.SowaTheme
 */