package vander.gabriel.pedrapapeltesourafragments.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import vander.gabriel.pedrapapeltesourafragments.ui.main.domain.Game
import vander.gabriel.pedrapapeltesourafragments.ui.main.domain.GameState

class MainViewModel : ViewModel() {
    private val mutableGame: MutableLiveData<Game> = MutableLiveData<Game>(Game())
    val game: LiveData<Game> get() = mutableGame

    fun startGame() {
        mutableGame.value = mutableGame.value?.copy(
            state = GameState.SELECTING_PLAYERS
        )
    }

    fun setPlayerAmount(amount: Int) {
        mutableGame.value = mutableGame.value?.copy(
            state = GameState.SELECTING_HAND,
            numberOfPlayers = amount
        )
    }
}