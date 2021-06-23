package com.app.artbooktestapp.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Arts::class],version = 1)
abstract class ArtDatabase:RoomDatabase() {
    abstract fun artDao():ArtDao
}