package vander.gabriel.pedrapapeltesourafragments.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import vander.gabriel.pedrapapeltesourafragments.R
import vander.gabriel.pedrapapeltesourafragments.databinding.FragmentPlayBinding
import vander.gabriel.pedrapapeltesourafragments.ui.main.domain.Hand
import vander.gabriel.pedrapapeltesourafragments.ui.main.domain.Play


/**
 * [RecyclerView.Adapter] that can display a [Play].
 */
class PlayRecyclerViewAdapter(
    private val values: List<Play>
) : RecyclerView.Adapter<PlayRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentPlayBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val play: Play = values[position]

        holder.playerName.text = play.playerName

        val handResource: Int = when (play.hand) {
            Hand.ROCK -> R.drawable.ic_rock
            Hand.PAPER -> R.drawable.ic_paper
            Hand.SCISSORS -> R.drawable.ic_scissors
        }

        holder.handIllustration.setImageResource(handResource)
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentPlayBinding) : RecyclerView.ViewHolder(binding.root) {
        val playerName: TextView = binding.playPlayerName
        val handIllustration: ImageView = binding.playIllustration

        override fun toString(): String {
            return super.toString() + " '" + playerName.text + "'"
        }
    }

}