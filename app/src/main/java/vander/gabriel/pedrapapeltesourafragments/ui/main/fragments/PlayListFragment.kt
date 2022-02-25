package vander.gabriel.pedrapapeltesourafragments.ui.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import vander.gabriel.pedrapapeltesourafragments.databinding.FragmentPlayListBinding
import vander.gabriel.pedrapapeltesourafragments.ui.main.adapters.PlayRecyclerViewAdapter
import vander.gabriel.pedrapapeltesourafragments.ui.main.view_models.MainViewModel

class PlayListFragment : Fragment() {

    private lateinit var binding: FragmentPlayListBinding

    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPlayListBinding.inflate(layoutInflater)

        val view = binding.root

        with(view) {
            mainViewModel.game.observe(viewLifecycleOwner) {
                layoutManager = when {
                    it.aiPlayers.size <= 1 -> LinearLayoutManager(
                        context,
                        LinearLayoutManager.HORIZONTAL,
                        false
                    )
                    else -> GridLayoutManager(context, it.aiPlayers.size)
                }

                adapter = PlayRecyclerViewAdapter(it.aiPlays)
            }

        }

        return view
    }
}