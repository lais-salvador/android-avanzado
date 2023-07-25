package com.example.android_avanzado.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.android_avanzado.data.local.model.HeroLocal

@Dao
interface HeroDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(heroList: List<HeroLocal>)

    @Query("SELECT * FROM HeroTable")
    suspend fun getAll(): List<HeroLocal>

    @Query("SELECT * FROM HeroTable")
    suspend fun getFavorites(): List<HeroLocal>

    @Delete
    suspend fun delete(model:HeroLocal)
}