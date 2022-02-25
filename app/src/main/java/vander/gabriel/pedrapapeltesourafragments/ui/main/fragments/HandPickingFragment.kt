package vander.gabriel.pedrapapeltesourafragments.ui.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import vander.gabriel.pedrapapeltesourafragments.databinding.FragmentHandPickingBinding
import vander.gabriel.pedrapapeltesourafragments.ui.main.models.Hand
import vander.gabriel.pedrapapeltesourafragments.ui.main.view_models.MainViewModel

class HandPickingFragment : Fragment() {

    companion object {
        fun newInstance() = HandPickingFragment()
    }

    private lateinit var binding: FragmentHandPickingBinding

    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHandPickingBinding.inflate(layoutInflater)

        val view = binding.root

        binding.handPickingRockButton.setOnClickListener {
            mainViewModel.setPlayerHand(Hand.ROCK)
        }

        binding.handPickingPaperButton.setOnClickListener {
            mainViewModel.setPlayerHand(Hand.PAPER)
        }

        binding.handPickingScissorsButton.setOnClickListener {
            mainViewModel.setPlayerHand(Hand.SCISSORS)
        }

        return view
    }
}