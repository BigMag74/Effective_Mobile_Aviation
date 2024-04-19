package com.example.effectivemobileaviation.di.search

import com.example.domain.search.useCases.GetDirectFlightsUseCase
import com.example.domain.search.useCases.impl.GetDirectFlightsUseCaseImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val searchDomainModule = module {
    factoryOf(::GetDirectFlightsUseCaseImpl) bind GetDirectFlightsUseCase::class
}