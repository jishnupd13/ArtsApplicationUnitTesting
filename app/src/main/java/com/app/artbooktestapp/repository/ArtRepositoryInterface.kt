package com.app.artbooktestapp.repository

import androidx.lifecycle.LiveData
import com.app.artbooktestapp.models.ImageResponse
import com.app.artbooktestapp.roomdb.Arts
import com.app.artbooktestapp.utils.Resource

interface ArtRepositoryInterface {

    suspend fun insertArt(art: Arts)

    suspend fun deleteArt(art: Arts)

    fun getArt(): LiveData<List<Arts>>

    suspend fun searchImage(imageString: String): Resource<ImageResponse>
}