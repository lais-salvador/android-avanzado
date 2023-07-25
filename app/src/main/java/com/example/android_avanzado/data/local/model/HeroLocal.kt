package com.example.android_avanzado.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "HeroTable")
data class HeroLocal (
    @PrimaryKey @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "photoUrl") val photoUrl: String,
    @ColumnInfo(name = "favorite") val favorite: Boolean
)