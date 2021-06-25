package com.app.artbooktestapp.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.app.artbooktestapp.R
import com.app.artbooktestapp.adapter.ImageRecyclerAdapter
import javax.inject.Inject

class FragmentImageApi @Inject constructor(
    val imageRecyclerAdapter: ImageRecyclerAdapter
):Fragment(R.layout.fragment_image_api) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}