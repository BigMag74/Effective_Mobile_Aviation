package com.example.effectivemobileaviation

import android.app.Application
import com.example.effectivemobileaviation.di.airTicketsDataModule
import com.example.effectivemobileaviation.di.airTicketsDomainModule
import com.example.effectivemobileaviation.di.airTicketsPresentationModule
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
                )
            )
        }
    }
}