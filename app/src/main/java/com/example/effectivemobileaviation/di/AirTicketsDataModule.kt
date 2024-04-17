package com.example.effectivemobileaviation.di

import com.example.data.airTickets.AirTicketsRepositoryImpl
import com.example.data.network.DataSource
import com.example.data.network.DataSourceImpl
import com.example.domain.airTickets.AirTicketsRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val airTicketsDataModule = module {
    singleOf(::DataSourceImpl) bind DataSource::class
    singleOf(::AirTicketsRepositoryImpl) bind AirTicketsRepository::class
}