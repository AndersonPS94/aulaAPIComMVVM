package com.example.aulaapicommvvm.domain.model

data class Postagem  (
    val idUsuario: Int,
    val codigo: Int,
    val titulo: String,
    val descricao: String
    ) {
    fun validarPostagem() {}
    fun trocarStatusPostagem() {}
    fun selecionarImagemPostagem() {}
}
