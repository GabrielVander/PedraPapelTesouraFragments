package vander.gabriel.pedrapapeltesourafragments.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import vander.gabriel.pedrapapeltesourafragments.R

class PlayerSelectionFragment : Fragment() {

    companion object {
        fun newInstance() = PlayerSelectionFragment()
    }

    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_player_selection, container, false)

        val twoPlayersButton: Button =
            view.findViewById<View>(R.id.playerSelectionTwoPlayersButton) as Button
        twoPlayersButton.setOnClickListener {
            mainViewModel.setPlayerAmount(2)
        }

        val threePlayersButton: Button =
            view.findViewById<View>(R.id.playerSelectionThreePlayersButton) as Button
        threePlayersButton.setOnClickListener {
            mainViewModel.setPlayerAmount(3)
        }

        return view
    }
}