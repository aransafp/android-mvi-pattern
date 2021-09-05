package com.aransafp.rickandmor.data.api

import com.aransafp.rickandmor.data.response.CharacterResponse

interface ApiHelper {

    suspend fun getCharacters(): CharacterResponse

}