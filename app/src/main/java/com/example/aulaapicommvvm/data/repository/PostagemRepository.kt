package com.example.aulaapicommvvm.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.aulaapicommvvm.data.api.JsonPlaceAPI
import com.example.aulaapicommvvm.data.model.PostagemResposta
import com.example.aulaapicommvvm.data.model.toPostagem
import com.example.aulaapicommvvm.domain.model.Postagem

class PostagemRepository(
    private val jsonPlaceAPI: JsonPlaceAPI
) : IPostagemRepository {

    //override val listaPostagensRepository = MutableLiveData<List<PostagemResposta>>()

    override suspend fun recuperarPostagens(): List<Postagem> {

        try {
            val retorno = jsonPlaceAPI.recuperarPostagens()
            if(retorno.isSuccessful && retorno.body() != null) {
                val listaPostagensResposta = retorno.body()
                val listapostagens = listaPostagensResposta?.map {
                    postagemResposta ->
                postagemResposta.toPostagem()
                }
                if (listapostagens != null){
                    return listapostagens
                }
            }
        } catch (erroRecuperarPostagem: Exception) {
            erroRecuperarPostagem.printStackTrace()
        }
        return emptyList()
        /*try {
           val retorno = jsonPlaceAPI.recuperarPostagens()
           if(retorno.isSuccessful && retorno.body() != null) {
              //listaPostagensRepository.postValue(retorno.body())
           }
       } catch (erroRecuperarPostagem: Exception) {
           erroRecuperarPostagem.printStackTrace()
           }
       }*/
    }
}