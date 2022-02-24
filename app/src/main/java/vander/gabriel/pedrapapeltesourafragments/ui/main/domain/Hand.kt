package vander.gabriel.pedrapapeltesourafragments.ui.main.domain

import vander.gabriel.pedrapapeltesourafragments.R

enum class Hand {
    ROCK {
        override val iconResourceId: Int
            get() = R.drawable.ic_rock
    },
    PAPER {
        override val iconResourceId: Int
            get() = R.drawable.ic_paper
    },
    SCISSORS {
        override val iconResourceId: Int
            get() = R.drawable.ic_scissors
    };

    abstract val iconResourceId: Int
}