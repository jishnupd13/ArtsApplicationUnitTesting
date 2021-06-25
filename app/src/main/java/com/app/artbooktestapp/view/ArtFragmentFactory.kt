package com.app.artbooktestapp.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.app.artbooktestapp.adapter.ArtRecyclerAdapter
import com.app.artbooktestapp.adapter.ImageRecyclerAdapter
import com.bumptech.glide.RequestManager
import javax.inject.Inject

class ArtFragmentFactory  @Inject constructor(
    private val imageRecyclerAdapter: ImageRecyclerAdapter,
    private val glide : RequestManager,
    private val artRecyclerAdapter: ArtRecyclerAdapter
) : FragmentFactory()  {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when(className){
            FragmentImageApi::class.java.name -> FragmentImageApi(imageRecyclerAdapter)
            ArtDetailsFragment::class.java.name -> ArtDetailsFragment(glide)
            ArtFragment::class.java.name -> ArtFragment(artRecyclerAdapter)
            else -> super.instantiate(classLoader, className)
        }
    }
}