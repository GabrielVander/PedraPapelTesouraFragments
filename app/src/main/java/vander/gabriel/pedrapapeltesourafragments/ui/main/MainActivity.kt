package vander.gabriel.pedrapapeltesourafragments.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import vander.gabriel.pedrapapeltesourafragments.R
import vander.gabriel.pedrapapeltesourafragments.ui.main.fragments.HandPickingFragment
import vander.gabriel.pedrapapeltesourafragments.ui.main.fragments.MainFragment
import vander.gabriel.pedrapapeltesourafragments.ui.main.fragments.PlayerSelectionFragment
import vander.gabriel.pedrapapeltesourafragments.ui.main.fragments.ResultsFragment
import vander.gabriel.pedrapapeltesourafragments.ui.main.models.GameState
import vander.gabriel.pedrapapeltesourafragments.ui.main.view_models.MainViewModel

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            mainViewModel.game.observe(this) { game ->
                when (game.state) {
                    GameState.NOT_INITIALIZED -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.container, MainFragment.newInstance())
                            .commitNow()
                    }
                    GameState.SELECTING_PLAYERS -> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.container, PlayerSelectionFragment.newInstance())
                            .commit()
                    }
                    GameState.SELECTING_HAND -> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.container, HandPickingFragment.newInstance())
                            .commit()
                    }
                    GameState.DISPLAYING_RESULTS -> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.container, ResultsFragment.newInstance())
                            .commit()
                    }
                    else -> {}
                }
            }
        }
    }
}