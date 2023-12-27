package com.example.domain.usecase

import com.example.domain.model.LocationModel
import com.example.domain.repository.LocationRepository

class UpdateLocationUseCase(private val locationRepository: LocationRepository) {

    suspend fun updateLocation(locationModel: LocationModel) {
        locationRepository.updateLocation(locationModel)
    }
}