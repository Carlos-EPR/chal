package br.com.fiap.sowa.model

data class UserEndereco(
    val logradouro: String?,
    val bairro: String?,
    val cidade: String?,
    val uf: String?,
    val cep: String?
)