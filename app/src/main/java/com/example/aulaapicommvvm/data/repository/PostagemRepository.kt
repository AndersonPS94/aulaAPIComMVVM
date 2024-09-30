package com.example.aulaapicommvvm.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.aulaapicommvvm.data.api.JsonPlaceAPI
import com.example.aulaapicommvvm.data.model.Postagem

class PostagemRepository(
    private val jsonPlaceAPI: JsonPlaceAPI
) : IPostagemRepository {

    override val listaPostagensRepository = MutableLiveData<List<Postagem>>()
    override suspend fun recuperarPostagens(){

       try {
           val retorno = jsonPlaceAPI.recuperarPostagens()
           if(retorno.isSuccessful && retorno.body() != null) {
              listaPostagensRepository.postValue(retorno.body())
           }
       } catch (erroRecuperarPostagem: Exception) {
           erroRecuperarPostagem.printStackTrace()
           }
       }
    }