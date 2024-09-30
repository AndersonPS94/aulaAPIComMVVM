package com.example.aulaapicommvvm.data.api

import com.example.aulaapicommvvm.data.model.Postagem
import retrofit2.Response
import retrofit2.http.GET

interface JsonPlaceAPI {
    @GET("/posts")
    suspend fun recuperarPostagens(): Response<List<Postagem>>
}