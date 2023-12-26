package com.example.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.data.dbmodel.LocationDbModel

@Database(entities = [LocationDbModel::class], exportSchema = false, version = 1)
abstract class LocationDataBase : RoomDatabase() {
    abstract fun getDao(): LocationDao

    companion object {
        @Volatile
        private var INSTANCE: LocationDataBase? = null

        fun getLocationDatabase(context: Context): LocationDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    LocationDataBase::class.java,
                    "location_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}