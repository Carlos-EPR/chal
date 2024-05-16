package br.com.fiap.sowa.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import br.com.fiap.sowa.R

@Composable
fun OutlinedTextFieldPassword(
    senha: String,
    onSenhaChange: (String) -> Unit,
    isPasswordVisible: Boolean,
    onPasswordVisibilityChange: (Boolean) -> Unit,
    isConfirmarSenha: Boolean = false,
    isMandatory: Boolean = false
) {
    OutlinedTextField(
        value = senha,
        onValueChange = onSenhaChange,
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.fillMaxWidth(),
        label = {
            Row {
                Text(text = if (isConfirmarSenha) "Confirmar senha" else "Senha")
                if (isMandatory) {
                    Text(
                        text = "*",
                        color = Color.Red,
                        modifier = Modifier.padding(start = 1.dp)
                    )
                }
            }
        },
        placeholder = {
            Text(
                text = if (isConfirmarSenha) "Confirme sua senha" else "Digite sua senha"
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(
                onClick = { onPasswordVisibilityChange(!isPasswordVisible) }
            ) {
                Icon(
                    painter = painterResource(
                        id = if (isPasswordVisible) R.drawable.eye_off else R.drawable.eye
                    ),
                    contentDescription = "Ícone de olho.",
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    )
}