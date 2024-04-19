package com.example.effectivemobileaviation.di.allTickets

import com.example.data.allTickets.AllTicketsRepositoryImpl
import com.example.domain.allTickets.AllTicketsRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val allTicketsDataModule = module {
    singleOf(::AllTicketsRepositoryImpl) bind AllTicketsRepository::class
}