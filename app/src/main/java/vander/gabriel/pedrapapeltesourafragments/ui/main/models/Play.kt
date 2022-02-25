package vander.gabriel.pedrapapeltesourafragments.ui.main.models

data class Play(val id: String, val playerName: String, val hand: Hand) {
    override fun toString(): String = playerName
}