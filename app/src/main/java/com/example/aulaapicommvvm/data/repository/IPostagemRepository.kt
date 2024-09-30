package com.example.aulaapicommvvm.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.aulaapicommvvm.data.model.Postagem

interface IPostagemRepository {

    val listaPostagensRepository: MutableLiveData<List<Postagem>>

    suspend fun recuperarPostagens()


}