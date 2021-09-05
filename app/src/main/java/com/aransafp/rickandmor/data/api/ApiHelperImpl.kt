package com.aransafp.rickandmor.data.api

import com.aransafp.rickandmor.data.response.CharacterResponse

class ApiHelperImpl(private val apiService: ApiService) : ApiHelper {

    override suspend fun getCharacters(): CharacterResponse {
        return apiService.getCharacters()
    }

}