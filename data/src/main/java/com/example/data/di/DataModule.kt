package com.example.data.di

import com.example.data.LocationDao
import com.example.data.LocationDataBase
import com.example.data.LocationRepositoryImpl
import com.example.data.TcpServiceRepositoryImpl
import com.example.domain.repository.LocationRepository
import com.example.domain.repository.TcpServiceRepository
import org.koin.dsl.module

val dataModule = module {

    single<LocationDao> {
        LocationDataBase.getLocationDatabase(context = get()).getDao()
    }

    single<LocationDataBase> {
        LocationDataBase.getLocationDatabase(context = get())
    }

    single<LocationRepository> { LocationRepositoryImpl(locationDao = get()) }

    single<TcpServiceRepository> { TcpServiceRepositoryImpl(context = get()) }

}