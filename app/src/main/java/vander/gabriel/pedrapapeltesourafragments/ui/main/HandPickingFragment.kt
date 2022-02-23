package vander.gabriel.pedrapapeltesourafragments.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import vander.gabriel.pedrapapeltesourafragments.R

class HandPickingFragment : Fragment() {

    companion object {
        fun newInstance() = HandPickingFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hand_picking, container, false)
    }
}