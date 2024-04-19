package com.example.effectivemobileaviation.di

import com.example.effectivemobileaviation.presentation.search.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module


val searchPresentationModule = module {
    viewModelOf(::SearchViewModel)
}