package com.app.artbooktestapp.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.app.artbooktestapp.R
import com.app.artbooktestapp.databinding.FragmentArtsBinding

class ArtFragment : Fragment(R.layout.fragment_arts) {

    private var fragmentArtsBinding:FragmentArtsBinding?=null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding=FragmentArtsBinding.bind(view)
        fragmentArtsBinding=binding

        binding.fab.setOnClickListener {
            findNavController().navigate(ArtFragmentDirections.actionArtFragmentToArtDetailsFragment())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentArtsBinding=null
    }
}