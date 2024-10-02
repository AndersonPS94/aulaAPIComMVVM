package com.example.aulaapicommvvm.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.aulaapicommvvm.data.repository.IPostagemRepository
import com.example.aulaapicommvvm.data.repository.PostagemRepository
import com.example.aulaapicommvvm.domain.usecase.PostagemUseCase

class MainViewModelFactory(
    private val postagemUseCase: PostagemUseCase
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
                MainViewModel(this.postagemUseCase) as T
        }else{
            throw IllegalArgumentException("ViewModel Nao encontrado")
        }
    }
}