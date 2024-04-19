package com.example.effectivemobileaviation.di.airTickets

import android.content.Context
import android.content.SharedPreferences
import com.example.data.airTickets.AirTicketsRepositoryImpl
import com.example.data.db.DataBaseDataSource
import com.example.data.db.DataBaseDataSourceImpl
import com.example.data.network.NetworkDataSource
import com.example.data.network.NetworkDataSourceImpl
import com.example.domain.airTickets.AirTicketsRepository
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val airTicketsDataModule = module {
    factory<SharedPreferences> {
        androidContext().getSharedPreferences("effective mobile shared preferences", Context.MODE_PRIVATE)
    }

    singleOf(::NetworkDataSourceImpl) bind NetworkDataSource::class
    singleOf(::DataBaseDataSourceImpl) bind DataBaseDataSource::class
    singleOf(::AirTicketsRepositoryImpl) bind AirTicketsRepository::class
}