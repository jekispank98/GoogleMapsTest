package com.example.domain.usecase

import com.example.domain.model.LocationModel
import com.example.domain.repository.LocationRepository

class GetListOfLocationUseCase(private val locationRepository : LocationRepository) {

    suspend fun getListOfLocation(): List<LocationModel> {
        return locationRepository.getListOfLocation()
    }
}