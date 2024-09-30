package com.example.aulaapicommvvm.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aulaapicommvvm.data.model.Postagem
import com.example.aulaapicommvvm.data.repository.IPostagemRepository
import com.example.aulaapicommvvm.data.repository.PostagemRepository
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: IPostagemRepository
): ViewModel() {

    var  listaPostagens = MutableLiveData<List<Postagem>>()
        get() = repository.listaPostagensRepository



    fun recuperarPostagens() {
        viewModelScope.launch {
            repository.recuperarPostagens()

        }
    }
}