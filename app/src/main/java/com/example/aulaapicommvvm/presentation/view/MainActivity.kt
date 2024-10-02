  package com.example.aulaapicommvvm.presentation.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.aulaapicommvvm.R
import com.example.aulaapicommvvm.data.api.RetrofitService
import com.example.aulaapicommvvm.data.repository.PostagemRepository
import com.example.aulaapicommvvm.databinding.ActivityMainBinding
import com.example.aulaapicommvvm.domain.usecase.PostagemUseCase
import com.example.aulaapicommvvm.presentation.viewmodel.MainViewModel
import com.example.aulaapicommvvm.presentation.viewmodel.MainViewModelFactory

  class MainActivity : AppCompatActivity() {
      private val binding by lazy {
          ActivityMainBinding.inflate(layoutInflater)
      }

      private lateinit var mainViewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        val jsonPlaceAPI = RetrofitService.recuperarJsonPlace()
       val postagemRepository = PostagemRepository(jsonPlaceAPI)
        val postagemUseCase = PostagemUseCase(postagemRepository)
        //val postagemRepository = PostagemFirebaseRepository()
        //val postagemRepository = PostagemBancoDadosRepository ()


        mainViewModel = ViewModelProvider(
            this,
             MainViewModelFactory(postagemUseCase)
        )[MainViewModel::class.java]
        //mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        mainViewModel.listaPostagens.observe(this) { postagens ->
            var listaResultado = ""
            postagens.forEach { postagem ->
                listaResultado += "${postagem.codigo}) - ${postagem.titulo}\n "
                binding.textResultado.text = listaResultado
            }
        }
    }
        override fun onStart() {
            super.onStart()
            mainViewModel.recuperarPostagens()
        }
    }
