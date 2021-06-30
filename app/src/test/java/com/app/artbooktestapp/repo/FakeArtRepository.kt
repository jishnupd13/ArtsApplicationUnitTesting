package com.app.artbooktestapp.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.app.artbooktestapp.models.ImageResponse
import com.app.artbooktestapp.repository.ArtRepositoryInterface
import com.app.artbooktestapp.roomdb.Arts
import com.app.artbooktestapp.utils.Resource

class FakeArtRepository : ArtRepositoryInterface {

    private val arts = mutableListOf<Arts>()
    private val artsLiveData = MutableLiveData<List<Arts>>(arts)

    override suspend fun insertArt(art: Arts) {
        arts.add(art)
        refreshLiveData()
    }

    override suspend fun deleteArt(art: Arts) {
        arts.remove(art)
        refreshLiveData()
    }

    override fun getArt(): LiveData<List<Arts>> {
        return artsLiveData
    }

    override suspend fun searchImage(imageString: String): Resource<ImageResponse> {
        return Resource.success(ImageResponse(listOf(), 0, 0))
    }


    private fun refreshLiveData() {
        artsLiveData.postValue(arts)
    }

}