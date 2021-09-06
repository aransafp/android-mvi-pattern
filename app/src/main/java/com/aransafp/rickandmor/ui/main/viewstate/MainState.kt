package com.aransafp.rickandmor.ui.main.viewstate

import com.aransafp.rickandmor.data.response.Character

sealed class MainState {

    object Idle : MainState()
    object Loading : MainState()
    data class Characters(val characters: List<Character>) : MainState()
    data class Error(val error: String?) : MainState()

}
