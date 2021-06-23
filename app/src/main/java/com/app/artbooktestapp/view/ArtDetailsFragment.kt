package com.app.artbooktestapp.view

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.app.artbooktestapp.R
import com.app.artbooktestapp.databinding.FragmentArtDetailsBinding
import com.bumptech.glide.RequestManager
import javax.inject.Inject

class ArtDetailsFragment  @Inject constructor(
    val glide : RequestManager
):Fragment(R.layout.fragment_art_details) {

    private var fragmentBinding:FragmentArtDetailsBinding?=null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding=FragmentArtDetailsBinding.bind(view)
        fragmentBinding=binding

        binding.imageArt.setOnClickListener {
            findNavController().navigate(ArtDetailsFragmentDirections.actionArtDetailsFragmentToFragmentImageApi())
        }

        val callBack=object :OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                findNavController().popBackStack()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(callBack)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentBinding=null
    }
}