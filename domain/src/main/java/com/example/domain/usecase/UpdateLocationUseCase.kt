package com.example.domain.usecase

import com.example.domain.model.LocationModel

class UpdateLocationUseCase(private val locationRepository: LocationRepository) {

    suspend fun updateLocation(locationModel: LocationModel) {
        locationRepository.updateLocation(locationModel)
    }
}