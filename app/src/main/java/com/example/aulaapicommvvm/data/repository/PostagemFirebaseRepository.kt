package com.example.aulaapicommvvm.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.aulaapicommvvm.data.model.Postagem

class PostagemFirebaseRepository() : IPostagemRepository  {
    override val listaPostagensRepository
    = MutableLiveData<List<Postagem>>()

    override suspend fun recuperarPostagens() {
        val lista = listOf(
            Postagem(1, 1, "Titulo 1", "Corpo 1"),
            Postagem(20, 2, "Titulo 2", "Corpo 2"),
        )
        listaPostagensRepository.postValue(lista)
    }
}