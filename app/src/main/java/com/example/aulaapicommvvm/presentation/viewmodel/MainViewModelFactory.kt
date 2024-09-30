package com.example.aulaapicommvvm.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.aulaapicommvvm.data.repository.IPostagemRepository
import com.example.aulaapicommvvm.data.repository.PostagemRepository

class MainViewModelFactory(
    private val repository: IPostagemRepository
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
                MainViewModel(this.repository) as T
        }else{
            throw IllegalArgumentException("ViewModel Nao encontrado")
        }
    }
}