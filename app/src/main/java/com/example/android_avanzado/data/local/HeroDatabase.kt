package com.example.android_avanzado.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.android_avanzado.data.local.model.HeroLocal

@Database(entities = [HeroLocal::class], version = 1)
abstract class HeroDatabase: RoomDatabase() {
    abstract fun heroDao(): HeroDao
}