package com.example.domain.usecase

import com.example.domain.model.LocationModel
import com.example.domain.repository.LocationRepository

class AddLocationUseCase(private val locationRepository: LocationRepository) {
    suspend fun addLocation(locationModel: LocationModel) {
        locationRepository.addLocation(locationModel)
    }
}