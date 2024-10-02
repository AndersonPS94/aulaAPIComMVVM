package com.example.aulaapicommvvm.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aulaapicommvvm.data.model.PostagemResposta
import com.example.aulaapicommvvm.domain.model.Postagem
import com.example.aulaapicommvvm.domain.usecase.PostagemUseCase
import kotlinx.coroutines.launch

class MainViewModel(
    private val postagemUseCase: PostagemUseCase
 ): ViewModel() {

    var  listaPostagens = MutableLiveData<List<Postagem>>()
       // get() = repository.listaPostagensRepository



    fun recuperarPostagens() {
        viewModelScope.launch {
            val postagens = postagemUseCase.recuperarPostagens()
            listaPostagens.postValue(postagens)
        }
    }
}