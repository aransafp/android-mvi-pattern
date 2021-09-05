package com.aransafp.rickandmor.data.repository

import com.aransafp.rickandmor.data.api.ApiHelper
import com.aransafp.rickandmor.data.response.CharacterResponse

class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getCharacters(): CharacterResponse = apiHelper.getCharacters()

}