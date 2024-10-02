package com.example.aulaapicommvvm.data.model

import com.example.aulaapicommvvm.domain.model.Postagem

data class PostagemResposta (
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String

)

fun PostagemResposta.toPostagem(): Postagem{
    return Postagem(
        idUsuario = this.userId,
        codigo = this.id,
        titulo = this.title,
        descricao = this.body
    )
}
