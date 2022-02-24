package vander.gabriel.pedrapapeltesourafragments.ui.main.domain

data class Play(val id: String, val playerName: String, val hand: Hand) {
    override fun toString(): String = playerName
}