package com.example.aulaapicommvvm.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.aulaapicommvvm.data.model.Postagem

class PostagemBancoDadosRepository : IPostagemRepository {
    override val listaPostagensRepository
    = MutableLiveData<List<Postagem>>()

    override suspend fun recuperarPostagens() {
        val lista = listOf(
            Postagem(1, 1, "Titulo 1", "Corpo 1"),
            Postagem(20, 2, "Titulo 2", "Corpo 2"),
            Postagem(30, 3, "Titulo 3", "Corpo 3"),
            Postagem(40, 4, "Titulo 4", "Corpo 4"),
            Postagem(50, 5, "Titulo 5", "Corpo 5"),
            Postagem(60, 6, "Titulo 6", "Corpo 6"),
            Postagem(70, 7, "Titulo 7", "Corpo 7"),
            Postagem(80, 8, "Titulo 8", "Corpo 8"),
            Postagem(90, 9, "Titulo 9", "Corpo 9"),
            Postagem(100, 10, "Titulo 10", "Corpo 10"),
            Postagem(110, 11, "Titulo 11", "Corpo 11"),
            Postagem(120, 12, "Titulo 12", "Corpo 12"),
        )
        listaPostagensRepository.postValue(lista)
    }
}

