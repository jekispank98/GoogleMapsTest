package com.example.googlemapstest.di

import com.example.googlemapstest.viewmodel.LocationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {

    viewModel<LocationViewModel> {
        LocationViewModel(
            getListOfLocationUseCase = get(),
            addLocationUseCase = get(),
            updateLocationUseCase = get(),
            deleteLocationUseCase = get(),
            startTcpServiceUseCase = get(),
            stopTcpServiceUseCase = get()
        )
    }
}