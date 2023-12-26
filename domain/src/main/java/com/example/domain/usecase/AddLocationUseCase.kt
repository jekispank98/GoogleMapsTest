package com.example.domain.usecase

import com.example.domain.model.LocationModel

class AddLocationUseCase(private val locationRepository: LocationRepository) {
    suspend fun addLocation(locationModel: LocationModel) {
        locationRepository.addLocation(locationModel)
    }
}