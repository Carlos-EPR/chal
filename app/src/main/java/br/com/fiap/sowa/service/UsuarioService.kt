package br.com.fiap.sowa.service

import br.com.fiap.sowa.model.Usuario
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface UsuarioService {

    @GET("usuarios/")
    fun getUsuariosUsuarios(): Call<List<Usuario>>

    @GET("usuario/{id}")
    fun getUsuarioId(@Path("id") id: String): Call<Usuario>

    @GET("usuario/busca?{prompt}")
    fun getUsuarioBusca(@Path("prompt") prompt: String): Call<List<Usuario>>

}