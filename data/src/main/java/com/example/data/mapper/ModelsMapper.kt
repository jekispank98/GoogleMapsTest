package com.example.data.mapper

import com.example.data.dbmodel.LocationDbModel
import com.example.domain.model.LocationModel

class ModelsMapper {

    fun mapDbModelToDomainModel(locationDbModel: LocationDbModel) : LocationModel {

        return LocationModel(
            id = locationDbModel.id,
            latitude = locationDbModel.latitude,
            longitude = locationDbModel.longitude
        )
    }

    fun mapDbListToDomainList(dbList: List<LocationDbModel>): List<LocationModel> {
        return dbList.map { mapDbModelToDomainModel(it) }
    }

    fun mapDomainModelToDbModel(locationModel: LocationModel) : LocationDbModel {
        return LocationDbModel(
            id = locationModel.id,
            latitude = locationModel.latitude,
            longitude = locationModel.longitude
        )
    }
}