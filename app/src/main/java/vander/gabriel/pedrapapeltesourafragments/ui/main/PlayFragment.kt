package vander.gabriel.pedrapapeltesourafragments.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import vander.gabriel.pedrapapeltesourafragments.R

class PlayFragment : Fragment() {

    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_play_list, container, false)

        if (view is RecyclerView) {
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

                    adapter = PlayRecyclerViewAdapter(it.plays)
                }

            }
        }
        return view
    }

    companion object {

        @JvmStatic
        fun newInstance() = PlayFragment()
    }
}