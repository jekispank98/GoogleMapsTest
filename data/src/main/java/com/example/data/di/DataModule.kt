package com.example.data.di

import com.example.data.LocationDao
import com.example.data.LocationDao_Impl
import com.example.data.LocationDataBase
import com.example.data.LocationRepositoryImpl
import com.example.domain.usecase.LocationRepository
import org.koin.dsl.module

val dataModule = module {

    single<LocationDao> {
        LocationDataBase.getLocationDatabase(context = get()).getDao()
    }

    single<LocationDataBase> {
        LocationDataBase.getLocationDatabase(context = get())
    }

    single<LocationRepository> { LocationRepositoryImpl(locationDao = get()) }

}