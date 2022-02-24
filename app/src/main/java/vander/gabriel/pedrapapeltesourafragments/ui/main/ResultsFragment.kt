package vander.gabriel.pedrapapeltesourafragments.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.activityViewModels
import vander.gabriel.pedrapapeltesourafragments.R
import vander.gabriel.pedrapapeltesourafragments.ui.main.domain.Hand

class ResultsFragment : Fragment() {

    companion object {
        fun newInstance() = ResultsFragment()
    }

    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_results, container, false)

        mainViewModel.game.observe(viewLifecycleOwner) {
            val playerHandIllustration: ImageView =
                view.findViewById<View>(R.id.resultsPlayerHandIllustration) as ImageView

            val handResource: Int = when (it.playerHand!!) {
                Hand.ROCK -> R.drawable.ic_rock
                Hand.PAPER -> R.drawable.ic_paper
                Hand.SCISSORS -> R.drawable.ic_scissors
            }

            playerHandIllustration.setImageResource(handResource)
        }

        return view
    }
}