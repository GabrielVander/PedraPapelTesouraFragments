package vander.gabriel.pedrapapeltesourafragments.ui.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import vander.gabriel.pedrapapeltesourafragments.databinding.FragmentPlayerSelectionBinding
import vander.gabriel.pedrapapeltesourafragments.ui.main.view_models.MainViewModel

class PlayerSelectionFragment : Fragment() {

    companion object {
        fun newInstance() = PlayerSelectionFragment()
    }

    private lateinit var binding: FragmentPlayerSelectionBinding

    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPlayerSelectionBinding.inflate(layoutInflater)

        val view = binding.root

        binding.playerSelectionTwoPlayersButton.setOnClickListener {
            mainViewModel.setPlayerAmount(2)
        }

        binding.playerSelectionThreePlayersButton.setOnClickListener {
            mainViewModel.setPlayerAmount(3)
        }

        return view
    }
}