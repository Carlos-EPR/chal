package br.com.fiap.sowa.model

data class Endereco (
    val cep: String?,
    var logradouro: String?,
    var bairro: String?,
    var localidade: String?,
    var uf: String?
)