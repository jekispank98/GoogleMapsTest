package com.example.data

import com.example.data.mapper.ModelsMapper
import com.example.domain.model.LocationModel
import com.example.domain.repository.LocationRepository

class LocationRepositoryImpl(private val locationDao: LocationDao): LocationRepository {
    val mapper = ModelsMapper()
    override suspend fun addLocation(locationModel: LocationModel) {
        locationDao.insertLocation(mapper.mapDomainModelToDbModel(locationModel))
    }

    override suspend fun updateLocation(locationModel: LocationModel) {
        TODO("Not yet implemented")
    }

    override suspend fun getListOfLocation(): List<LocationModel> {
        return mapper.mapDbListToDomainList(locationDao.getListOfLocation())
    }

    override suspend fun deleteLocation(locationModel: LocationModel) {
        TODO("Not yet implemented")
    }
}