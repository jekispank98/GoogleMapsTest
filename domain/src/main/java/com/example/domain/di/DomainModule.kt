package com.example.domain.di

import com.example.domain.usecase.AddLocationUseCase
import com.example.domain.usecase.DeleteLocationUseCase
import com.example.domain.usecase.GetListOfLocationUseCase
import com.example.domain.usecase.StartTcpServiceUseCase
import com.example.domain.usecase.StopTcpServiceUseCase
import com.example.domain.usecase.UpdateLocationUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<AddLocationUseCase> { AddLocationUseCase(locationRepository = get()) }

    factory<UpdateLocationUseCase> { UpdateLocationUseCase(locationRepository = get()) }

    factory<GetListOfLocationUseCase> { GetListOfLocationUseCase(locationRepository = get()) }

    factory<DeleteLocationUseCase> { DeleteLocationUseCase(locationRepository = get()) }

    factory<StartTcpServiceUseCase> {StartTcpServiceUseCase(tcpRepo = get())}

    factory<StopTcpServiceUseCase> {StopTcpServiceUseCase(tcpRepo = get())}

}