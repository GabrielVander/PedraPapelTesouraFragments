package vander.gabriel.pedrapapeltesourafragments.ui.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import vander.gabriel.pedrapapeltesourafragments.databinding.FragmentResultsBinding
import vander.gabriel.pedrapapeltesourafragments.ui.main.view_models.MainViewModel

class ResultsFragment : Fragment() {

    companion object {
        fun newInstance() = ResultsFragment()
    }

    private lateinit var binding: FragmentResultsBinding

    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultsBinding.inflate(layoutInflater)

        val view = binding.root

        binding.resultsExitButton.setOnClickListener {
            mainViewModel.resetGame()
        }

        mainViewModel.game.observe(viewLifecycleOwner) { game ->
            game.playerHand?.let {
                binding.resultsPlayerHandIllustration.setImageResource(it.iconResourceId)
            }

            game.result?.let {
                binding.resultsText.setText(it.displayResourceId)
            }
        }

        return view
    }
}