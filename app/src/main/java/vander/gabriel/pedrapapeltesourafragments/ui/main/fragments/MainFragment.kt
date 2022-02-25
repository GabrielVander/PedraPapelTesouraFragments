package vander.gabriel.pedrapapeltesourafragments.ui.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import vander.gabriel.pedrapapeltesourafragments.databinding.MainFragmentBinding
import vander.gabriel.pedrapapeltesourafragments.ui.main.view_models.MainViewModel


class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var binding: MainFragmentBinding

    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(layoutInflater)

        val view = binding.root

        binding.mainFragmentStartGameButton.setOnClickListener {
            mainViewModel.startGame()
        }

        return view
    }
}