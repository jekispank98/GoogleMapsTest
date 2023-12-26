package com.example.googlemapstest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.LocationModel
import com.example.domain.usecase.AddLocationUseCase
import com.example.domain.usecase.DeleteLocationUseCase
import com.example.domain.usecase.GetListOfLocationUseCase
import com.example.domain.usecase.UpdateLocationUseCase
import kotlinx.coroutines.launch

class LocationViewModel(
    private val getListOfLocationUseCase: GetListOfLocationUseCase,
    private val addLocationUseCase: AddLocationUseCase,
    private val updateLocationUseCase: UpdateLocationUseCase,
    private val deleteLocationUseCase: DeleteLocationUseCase
): ViewModel() {

    private var _locations = MutableLiveData<List<LocationModel>?>()
    val locations: LiveData<List<LocationModel>?> = _locations


    fun getListOfLocation() {
        viewModelScope.launch {
            val listOfLocation = getListOfLocationUseCase.getListOfLocation()
            _locations.value = listOfLocation
        }
    }

    fun addLocation(locationModel: LocationModel) {
        viewModelScope.launch {
            addLocationUseCase.addLocation(locationModel)
        }
    }
}