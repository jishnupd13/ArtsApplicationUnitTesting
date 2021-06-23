package com.app.artbooktestapp.roomdb

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ArtDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArt(arts: Arts)

    @Delete
    suspend fun deleteArt(arts: Arts)

    @Query("select * from arts")
    fun observeArts(): LiveData<List<Arts>>
}