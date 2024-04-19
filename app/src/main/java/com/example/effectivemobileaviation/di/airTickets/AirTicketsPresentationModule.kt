package com.example.effectivemobileaviation.di.airTickets

import com.example.effectivemobileaviation.presentation.airTickets.AirTicketsViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val airTicketsPresentationModule = module {
    viewModelOf(::AirTicketsViewModel)
}