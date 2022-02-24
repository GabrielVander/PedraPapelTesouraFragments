package vander.gabriel.pedrapapeltesourafragments.ui.main.models

data class Game(
    val state: GameState = GameState.NOT_INITIALIZED,
    val numberOfPlayers: Int = 2,
    val aiPlayers: List<Player> = listOf(),
    val playerHand: Hand? = null,
    val plays: List<Play> = listOf(),
)