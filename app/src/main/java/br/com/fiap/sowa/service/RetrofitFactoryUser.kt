package br.com.fiap.sowa.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactoryUser {

    private val URL = "http://191.239.120.22:3000/"

    private val retrofitFactoryUser = Retrofit
        .Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getUsuarioService(): UsuarioService {
        return retrofitFactoryUser.create(UsuarioService::class.java)
    }

}