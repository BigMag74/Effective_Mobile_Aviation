package com.example.effectivemobileaviation

import android.app.Application
import com.example.effectivemobileaviation.di.airTickets.airTicketsDataModule
import com.example.effectivemobileaviation.di.airTickets.airTicketsDomainModule
import com.example.effectivemobileaviation.di.airTickets.airTicketsPresentationModule
import com.example.effectivemobileaviation.di.search.searchDataModule
import com.example.effectivemobileaviation.di.search.searchDomainModule
import com.example.effectivemobileaviation.di.search.searchPresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    airTicketsDataModule,
                    airTicketsPresentationModule,
                    airTicketsDomainModule,
                    searchPresentationModule,
                    searchDataModule,
                    searchDomainModule,
                )
            )
        }
    }
}