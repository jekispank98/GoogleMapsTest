package com.example.domain.usecase

import com.example.domain.model.LocationModel

class DeleteLocationUseCase (private val locationRepository: LocationRepository) {

    suspend fun deleteLocation(locationModel: LocationModel) {
        locationRepository.deleteLocation(locationModel)
    }
}