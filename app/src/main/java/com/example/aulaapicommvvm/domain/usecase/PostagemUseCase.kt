package com.example.aulaapicommvvm.domain.usecase

import com.example.aulaapicommvvm.data.repository.IPostagemRepository
import com.example.aulaapicommvvm.domain.model.Postagem

class PostagemUseCase(
    private val repository: IPostagemRepository

) {

    suspend fun recuperarPostagens() : List<Postagem> {
        try {
            return  repository.recuperarPostagens()

        }catch (erroRecuperarPostagens: Exception) {
            erroRecuperarPostagens.printStackTrace()

        }
        return emptyList()
    }
}