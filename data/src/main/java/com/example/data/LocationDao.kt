package com.example.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.data.dbmodel.LocationDbModel

@Dao
interface LocationDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertLocation(locationDbModel: LocationDbModel)

    @Update
    suspend fun updateLocation(locationDbModel: LocationDbModel)

    @Query("SELECT * FROM LocationDbModel")
    suspend fun getListOfLocation() : List<LocationDbModel>

    @Query("DELETE FROM LocationDbModel WHERE id=:id")
    suspend fun deleteLocation(id: Int)
}