package vander.gabriel.pedrapapeltesourafragments.ui.main.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import vander.gabriel.pedrapapeltesourafragments.ui.main.models.*
import java.util.*

class MainViewModel : ViewModel() {
    private val mutableGame: MutableLiveData<Game> = MutableLiveData<Game>(Game())
    val game: LiveData<Game> get() = mutableGame

    fun startGame() {
        mutableGame.value = mutableGame.value?.copy(
            state = GameState.SELECTING_PLAYERS
        )
    }

    fun setPlayerAmount(amount: Int) {
        val amountOfAiPlayers = amount - 1

        val aiPlayers: MutableList<Player> = mutableListOf()

        for (i in 1..amountOfAiPlayers) {
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
            aiPlayers = aiPlayers!!,
            aiPlays = getAiPlays(aiPlayers)
        )

        calculateResult()
    }

    private fun calculateResult() {
        val game: Game? = mutableGame.value

        mutableGame.value = game?.copy(
            state = GameState.DISPLAYING_RESULTS,
            result = game.playerHand?.let { getResult(it, game.aiPlays) }
        )
    }

    private fun getResult(playerHand: Hand, plays: List<Play>): Result {
        val aiHands: List<Hand> = plays.map { play -> play.hand }

        if (aiHands.all { hand -> hand.isCounteredBy(playerHand) }) {
            return Result.PLAYER_WON
        } else if (aiHands.any { hand -> hand.counters(playerHand) }) {
            return Result.PLAYER_LOST
        }

        return Result.DRAW
    }

    private fun getAiPlays(aiPlayers: List<Player>): List<Play> {
        return aiPlayers.map { player ->
            Play(
                id = UUID.randomUUID().toString(),
                playerName = player.name,
                hand = player.hand!!
            )
        }
    }

    fun resetGame() {
        mutableGame.value = Game()
    }
}