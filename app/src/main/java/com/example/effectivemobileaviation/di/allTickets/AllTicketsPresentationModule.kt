package com.example.effectivemobileaviation.di.allTickets

import com.example.effectivemobileaviation.presentation.allTickets.AllTicketsFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val allTicketsPresentationModule = module {
    viewModelOf(::AllTicketsFragmentViewModel)
}