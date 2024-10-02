package com.example.aulaapicommvvm.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.aulaapicommvvm.data.model.PostagemResposta
import com.example.aulaapicommvvm.domain.model.Postagem

interface  IPostagemRepository {

    suspend fun recuperarPostagens(): List<Postagem >


}