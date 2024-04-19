package com.example.effectivemobileaviation.di.airTickets

import com.example.domain.airTickets.useCases.GetFlyAwayMusicallyItemsUseCase
import com.example.domain.airTickets.useCases.GetLastSearchUseCase
import com.example.domain.airTickets.useCases.SaveLastSearchUseCase
import com.example.domain.airTickets.useCases.impl.SaveLastSearchUseCaseImpl
import com.example.domain.airTickets.useCases.impl.GetFlyAwayMusicallyItemsUseCaseImpl
import com.example.domain.airTickets.useCases.impl.GetLastSearchUseCaseImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val airTicketsDomainModule = module {
    factoryOf(::GetFlyAwayMusicallyItemsUseCaseImpl) bind GetFlyAwayMusicallyItemsUseCase::class
    factoryOf(::SaveLastSearchUseCaseImpl) bind SaveLastSearchUseCase::class
    factoryOf(::GetLastSearchUseCaseImpl) bind GetLastSearchUseCase::class
}