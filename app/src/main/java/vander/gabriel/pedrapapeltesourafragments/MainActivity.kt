package vander.gabriel.pedrapapeltesourafragments

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import vander.gabriel.pedrapapeltesourafragments.ui.main.HandPickingFragment
import vander.gabriel.pedrapapeltesourafragments.ui.main.MainFragment
import vander.gabriel.pedrapapeltesourafragments.ui.main.MainViewModel
import vander.gabriel.pedrapapeltesourafragments.ui.main.PlayerSelectionFragment
import vander.gabriel.pedrapapeltesourafragments.ui.main.domain.GameState

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
                            .addToBackStack("playerSelection")
                            .commit()
                    }
                    GameState.SELECTING_HAND -> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.container, HandPickingFragment.newInstance())
                            .addToBackStack("handPicking")
                            .commit()
                    }
                }
            }
        }
    }
}