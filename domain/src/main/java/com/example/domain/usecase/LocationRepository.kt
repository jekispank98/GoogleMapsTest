package com.example.domain.usecase

import com.example.domain.model.LocationModel

interface LocationRepository {

    suspend fun addLocation(locationModel: LocationModel)

    suspend fun updateLocation(locationModel: LocationModel)

    suspend fun getListOfLocation(): List<LocationModel>

    suspend fun deleteLocation(locationModel: LocationModel)
}