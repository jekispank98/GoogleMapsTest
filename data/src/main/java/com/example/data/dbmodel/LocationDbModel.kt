package com.example.data.dbmodel

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LocationDbModel (

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo
    val latitude: Double,

    @ColumnInfo
    val longitude: Double
)