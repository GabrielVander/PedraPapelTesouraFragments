package vander.gabriel.pedrapapeltesourafragments.ui.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import vander.gabriel.pedrapapeltesourafragments.R
import vander.gabriel.pedrapapeltesourafragments.ui.main.view_models.MainViewModel

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

            it.playerHand?.let {
                    it1 -> playerHandIllustration.setImageResource(it1.iconResourceId)
            }
        }

        return view
    }
}