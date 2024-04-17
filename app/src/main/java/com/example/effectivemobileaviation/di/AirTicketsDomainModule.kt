package com.example.effectivemobileaviation.di

import com.example.domain.airTickets.useCases.GetFlyAwayMusicallyItemsUseCase
import com.example.domain.airTickets.useCases.impl.GetFlyAwayMusicallyItemsUseCaseImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val airTicketsDomainModule = module {
    factoryOf(::GetFlyAwayMusicallyItemsUseCaseImpl) bind GetFlyAwayMusicallyItemsUseCase::class
}