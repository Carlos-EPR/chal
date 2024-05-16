package br.com.fiap.sowa.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.sowa.R
import br.com.fiap.sowa.model.Endereco
import br.com.fiap.sowa.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun FormCadastro(navController: NavController) {
    var escolaDestaque by remember { mutableStateOf(true) }
    var profissionalDestaque by remember { mutableStateOf(false) }
    var endereco by remember { mutableStateOf(Endereco("", "", "", "", "")) }
    var nome by remember { mutableStateOf("") }
    var cep by remember { mutableStateOf("") }
    var areas by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var csenha by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(false) }
    var isConfirmedPasswordVisible by remember { mutableStateOf(false) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(horizontal = 64.dp)
    )

    {
        Text(
            text = "Você é um(a)",
            fontSize = 15.sp,
            color = Color.Black,
            textAlign = TextAlign.Left,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        Box {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = {
                        escolaDestaque = true
                        profissionalDestaque = false
                    },
                    shape = RoundedCornerShape(10.dp),
                    colors = if (escolaDestaque) ButtonDefaults.buttonColors(colorResource(id = R.color.bluePrincipal)) else
                        ButtonDefaults.buttonColors(colorResource(id = R.color.white)),
                    border = BorderStroke(1.dp, colorResource(id = R.color.bluePrincipal)),
                    modifier = Modifier
                        .width(100.dp)
                        .height(35.dp)
                ) {
                    Text(
                        text = "Escola",
                        color = if (escolaDestaque) Color.White else colorResource(id = R.color.bluePrincipal),
                        fontSize = 12.sp,
                    )
                }

                Button(
                    onClick = {
                        escolaDestaque = false
                        profissionalDestaque = true
                    },
                    colors = if (profissionalDestaque) ButtonDefaults.buttonColors(colorResource(id = R.color.bluePrincipal)) else
                        ButtonDefaults.buttonColors(colorResource(id = R.color.white)),
                    border = BorderStroke(1.dp, colorResource(id = R.color.bluePrincipal)),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .width(120.dp)
                        .height(35.dp)
                ) {
                    Text(
                        text = "Profissional",
                        color = if (profissionalDestaque) Color.White else colorResource(id = R.color.bluePrincipal),
                        fontSize = 12.sp,
                    )
                }
            }
        }
        OutlinedTextFieldModel(
            value = nome,
            label = "Nome",
            placeholder = if (profissionalDestaque) "Digite o nome do profissional" else "Digite o nome da escola",
            modifier = Modifier,
            keyboardType = KeyboardType.Text,
            atualizarValor = { nome = it },
        )
        OutlinedTextFieldModel(
            value = areas,
            label = if (profissionalDestaque) "Áreas de atuação" else "Áreas de interesse",
            placeholder = if (profissionalDestaque) "Digite suas áreas de atuação" else "Digite suas áreas de interesse",
            modifier = Modifier,
            keyboardType = KeyboardType.Text,
            atualizarValor = { areas = it }
        )
        OutlinedTextField(
            value = cep,
            onValueChange = { cep = it },
            label = {
                Row {
                    Text("CEP")
                    Text(
                        text = "*",
                        color = Color.Red
                    )
                }
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Number
            ),
            shape = RoundedCornerShape(10.dp),
            keyboardActions = KeyboardActions(onDone = {
                searchCep(cep) { enderecoResult ->
                    endereco = enderecoResult ?: Endereco(
                        "",
                        "",
                        "",
                        "",
                        ""
                    )
                }
            }),

            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                searchCep(cep) { enderecoResult ->
                    endereco = enderecoResult ?: Endereco("", "", "", "", "")
                }
            },
            enabled = cep.isNotBlank(),
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            colors = if (cep.isNotBlank()) ButtonDefaults.buttonColors(colorResource(id = R.color.bluePrincipal))
            else ButtonDefaults.buttonColors(colorResource(id = R.color.white))
        ) {
            Text("Buscar Endereço")
        }
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = endereco.logradouro ?: "",
            onValueChange = { endereco.logradouro = it },
            label = { Text("Endereço") },
            enabled = false,
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = endereco.bairro ?: "",
            onValueChange = { endereco.bairro = it },
            label = { Text("Bairro") },
            enabled = false,
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = endereco.localidade ?: "",
            onValueChange = { endereco.localidade = it },
            label = { Text("Cidade") },
            enabled = false,
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = endereco.uf ?: "",
            onValueChange = { endereco.uf = it },
            label = { Text("Estado") },
            enabled = false,
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextFieldModel(
            value = email,
            label = "E-mail",
            placeholder = "Digite seu e-mail",
            modifier = Modifier,
            keyboardType = KeyboardType.Email,
            atualizarValor = { areas = it },
            isMandatory = true
        )
        OutlinedTextFieldPassword(
            senha = senha,
            onSenhaChange = { novaSenha ->
                senha = novaSenha
            },
            isPasswordVisible = isPasswordVisible,
            onPasswordVisibilityChange = { visibilidade ->
                isPasswordVisible = visibilidade
            },
            isMandatory = true,
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextFieldPassword(
            senha = csenha,
            onSenhaChange = { confirmarNovaSenha ->
                csenha = confirmarNovaSenha
            },
            isPasswordVisible = isConfirmedPasswordVisible,
            onPasswordVisibilityChange = { visibilidade ->
                isConfirmedPasswordVisible = visibilidade
            },
            isConfirmarSenha = true,
            isMandatory = true
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate("home")},
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
                text = "ENVIAR",
                fontSize = 16.sp,
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}

private fun searchCep(cep: String, onResult: (Endereco?) -> Unit) {
    val call = RetrofitFactory().getCepService().getEnderecoByCep(cep = cep)
    call.enqueue(object : Callback<Endereco> {
        override fun onResponse(call: Call<Endereco>, response: Response<Endereco>) {
            if (response.isSuccessful) {
                val endereco = response.body()
                onResult(endereco)
            } else {
                onResult(null)
            }
        }

        override fun onFailure(call: Call<Endereco>, t: Throwable) {
            onResult(null)
        }
    })
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewFormCadastro() {
    val navController = rememberNavController()
    Box(modifier = Modifier.fillMaxSize()) {
        FormCadastro(navController = navController)
    }
}