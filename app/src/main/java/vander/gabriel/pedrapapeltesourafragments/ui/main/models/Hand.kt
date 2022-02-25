package vander.gabriel.pedrapapeltesourafragments.ui.main.models

import vander.gabriel.pedrapapeltesourafragments.R

enum class Hand {
    ROCK {
        override val iconResourceId: Int
            get() = R.drawable.ic_rock

        override fun isCounteredBy(hand: Hand): Boolean = hand == PAPER
        override fun counters(hand: Hand): Boolean = hand == SCISSORS
    },
    PAPER {
        override val iconResourceId: Int
            get() = R.drawable.ic_paper

        override fun isCounteredBy(hand: Hand): Boolean = hand == SCISSORS
        override fun counters(hand: Hand): Boolean = hand == ROCK
    },
    SCISSORS {
        override val iconResourceId: Int
            get() = R.drawable.ic_scissors

        override fun isCounteredBy(hand: Hand): Boolean = hand == ROCK
        override fun counters(hand: Hand): Boolean = hand == PAPER

    };

    abstract val iconResourceId: Int
    abstract fun isCounteredBy(hand: Hand): Boolean
    abstract fun counters(hand: Hand): Boolean
}