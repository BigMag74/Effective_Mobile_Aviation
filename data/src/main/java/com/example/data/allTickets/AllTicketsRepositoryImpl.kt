package com.example.data.allTickets

import com.example.data.network.NetworkDataSource
import com.example.domain.allTickets.AllTicketsRepository
import com.example.domain.model.TicketFullInfo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AllTicketsRepositoryImpl(
    private val networkDataSource: NetworkDataSource,
) : AllTicketsRepository {

    override fun getAllTickets(): Flow<List<TicketFullInfo>> = flow {
        val response = networkDataSource.doRequest(AllTicketsRequest())
        when (response.resultCode) {
            200 -> {
                emit((response as AllTicketsResponse).tickets.map {
                    TicketFullInfo(
                        id = it.id,
                        badge = it.badge,
                        price = it.price,
                        departure = it.departure,
                        arrival = it.arrival,
                        hasTransfer = it.hasTransfer,
                    )
                })
            }
        }
    }
}