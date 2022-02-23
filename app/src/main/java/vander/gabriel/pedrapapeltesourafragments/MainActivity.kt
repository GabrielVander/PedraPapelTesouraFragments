package vander.gabriel.pedrapapeltesourafragments

import android.os.Bundle
import android.text.TextUtils.replace
import android.view.View
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import vander.gabriel.pedrapapeltesourafragments.ui.main.MainFragment
import vander.gabriel.pedrapapeltesourafragments.ui.main.PlayerSelectionFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }

    fun startGame(view: View) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, PlayerSelectionFragment())
            .addToBackStack("playerSelection")
            .commit()
    }
}