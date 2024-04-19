package com.example.effectivemobileaviation.di.allTickets

import com.example.domain.allTickets.useCases.GetAllTicketsUseCase
import com.example.domain.allTickets.useCases.impl.GetAllTicketsUseCaseImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import org.koin.dsl.bind

val allTicketsDomainModule = module {
    factoryOf(::GetAllTicketsUseCaseImpl) bind GetAllTicketsUseCase::class
}