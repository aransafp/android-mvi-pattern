package com.aransafp.rickandmor.data.api

import com.aransafp.rickandmor.data.response.CharacterResponse
import retrofit2.http.GET

interface ApiService {

    @GET("character")
    suspend fun getCharacters(): CharacterResponse

}