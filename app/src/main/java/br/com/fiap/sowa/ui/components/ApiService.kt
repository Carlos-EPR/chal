package br.com.fiap.sowa.ui.components

import kotlinx.coroutines.CoroutineScope
import br.com.fiap.sowa.model.Usuario
import br.com.fiap.sowa.service.RetrofitFactoryUser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun searchUsers(onResult: (List<Usuario>?) -> Unit) {
    val call = RetrofitFactoryUser().getUsuarioService().getUsuariosUsuarios()
    call.enqueue(object : Callback<List<Usuario>> {

        override fun onResponse(call: Call<List<Usuario>>, response: Response<List<Usuario>>) {
            if (response.isSuccessful) {
                val usuarios = response.body()
                if (usuarios != null) {
                    onResult(usuarios)
                } else {
                    onResult(emptyList())
                }
            } else {
                onResult(emptyList())
            }
        }

        override fun onFailure(call: Call<List<Usuario>>, t: Throwable) {
            onResult(emptyList())
        }
    })
}

fun getUserById(id: String, onResult: (Usuario?) -> Unit) {
    val call = RetrofitFactoryUser().getUsuarioService().getUsuarioId(id)
    call.enqueue(object : Callback<Usuario> {

        override fun onResponse(call: Call<Usuario>, response: Response<Usuario>) {
            if (response.isSuccessful) {
                val usuario = response.body()
                onResult(usuario)
            } else {
                onResult(null)
            }
        }

        override fun onFailure(call: Call<Usuario>, t: Throwable) {
            onResult(null)
        }
    })
}

fun searchUsersByPrompt(prompt: String, onResult: (List<Usuario>?) -> Unit) {
    val call = RetrofitFactoryUser().getUsuarioService().getUsuarioBusca(prompt)
    call.enqueue(object : Callback<List<Usuario>> {
        override fun onResponse(call: Call<List<Usuario>>, response: Response<List<Usuario>>) {
            if (response.isSuccessful) {
                val usuarios = response.body()
                onResult(usuarios)
            } else {
                onResult(emptyList())
            }
        }

        override fun onFailure(call: Call<List<Usuario>>, t: Throwable) {
            onResult(emptyList())
        }
    })
}
