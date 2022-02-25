package vander.gabriel.pedrapapeltesourafragments.ui.main.models

import vander.gabriel.pedrapapeltesourafragments.R

enum class Result {
    PLAYER_LOST {
        override val displayResourceId: Int
            get() = R.string.results_player_lost
    },
    PLAYER_WON {
        override val displayResourceId: Int
            get() = R.string.results_player_won
    },
    DRAW {
        override val displayResourceId: Int
            get() = R.string.results_draw
    };

    abstract val displayResourceId: Int
}