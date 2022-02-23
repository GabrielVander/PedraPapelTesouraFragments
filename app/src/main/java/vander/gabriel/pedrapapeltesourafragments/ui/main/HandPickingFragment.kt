package vander.gabriel.pedrapapeltesourafragments.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import vander.gabriel.pedrapapeltesourafragments.R
import vander.gabriel.pedrapapeltesourafragments.ui.main.domain.Hand

class HandPickingFragment : Fragment() {

    companion object {
        fun newInstance() = HandPickingFragment()
    }

    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_hand_picking, container, false)

        val rockButton: ImageButton =
            view.findViewById<View>(R.id.handPickingRockButton) as ImageButton
        rockButton.setOnClickListener {
            mainViewModel.setPlayerHand(Hand.ROCK)
        }

        val paperButton: ImageButton =
            view.findViewById<View>(R.id.handPickingPaperButton) as ImageButton
        paperButton.setOnClickListener {
            mainViewModel.setPlayerHand(Hand.PAPER)
        }

        val scissorsButton: ImageButton =
            view.findViewById<View>(R.id.handPickingScissorsButton) as ImageButton
        scissorsButton.setOnClickListener {
            mainViewModel.setPlayerHand(Hand.SCISSORS)
        }

        return view
    }
}