package vander.gabriel.pedrapapeltesourafragments.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import vander.gabriel.pedrapapeltesourafragments.ui.main.domain.Game
import vander.gabriel.pedrapapeltesourafragments.ui.main.domain.GameState
import vander.gabriel.pedrapapeltesourafragments.ui.main.domain.Hand
import vander.gabriel.pedrapapeltesourafragments.ui.main.domain.Player

class MainViewModel : ViewModel() {
    private val mutableGame: MutableLiveData<Game> = MutableLiveData<Game>(Game())
    val game: LiveData<Game> get() = mutableGame

    fun startGame() {
        mutableGame.value = mutableGame.value?.copy(
            state = GameState.SELECTING_PLAYERS
        )
    }

    fun setPlayerAmount(amount: Int) {
        val aiPlayers: MutableList<Player> = mutableListOf()

        for (i in 0 until amount) {
            aiPlayers.add(Player("Computer #$i"))
        }

        mutableGame.value = mutableGame.value?.copy(
            state = GameState.SELECTING_HAND,
            numberOfPlayers = amount,
            aiPlayers = aiPlayers
        )
    }

    fun setPlayerHand(hand: Hand) {
        mutableGame.value = mutableGame.value?.copy(
            state = GameState.CALCULATING_MOVES,
            playerHand = hand
        )

        calculateMoves()
    }

    private fun calculateMoves() {
        val game: Game? = mutableGame.value

        val aiPlayers: List<Player>? = game?.aiPlayers?.map { player ->
            player.copy(
                hand = Hand.values().toList().shuffled().first()
            )
        }

        mutableGame.value = game?.copy(
            state = GameState.DISPLAYING_RESULTS,
            aiPlayers = aiPlayers!!,
        )
    }
}