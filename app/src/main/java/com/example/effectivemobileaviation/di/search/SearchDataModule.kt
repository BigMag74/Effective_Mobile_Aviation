package com.example.effectivemobileaviation.di.search

import com.example.data.search.SearchRepositoryImpl
import com.example.domain.search.SearchRepository
import org.koin.dsl.module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind

val searchDataModule = module {
    singleOf(::SearchRepositoryImpl) bind SearchRepository::class
}