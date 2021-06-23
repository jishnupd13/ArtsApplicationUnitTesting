package com.app.artbooktestapp.repository

import androidx.lifecycle.LiveData
import com.app.artbooktestapp.api.RetrofitApi
import com.app.artbooktestapp.models.ImageResponse
import com.app.artbooktestapp.roomdb.ArtDao
import com.app.artbooktestapp.roomdb.Arts
import com.app.artbooktestapp.utils.Resource
import javax.inject.Inject

class ArtRepository @Inject constructor(
    private val artDao: ArtDao,
    private val retrofitApi: RetrofitApi
) : ArtRepositoryInterface {
    override suspend fun insertArt(art: Arts) {
        artDao.insertArt(art)
    }

    override suspend fun deleteArt(art: Arts) {
        artDao.deleteArt(art)
    }

    override fun getArt(): LiveData<List<Arts>> {
        return artDao.observeArts()
    }

    override suspend fun searchImage(imageString: String): Resource<ImageResponse> {
        return try {
            val response = retrofitApi.imageSearch(imageString)
            if (response.isSuccessful) {
                response.body()?.let {
                    return@let Resource.success(it)
                } ?: Resource.error("Error", null)
            } else {
                Resource.error("Error", null)
            }
        } catch (e: Exception) {
            Resource.error("No data!", null)
        }
    }
}