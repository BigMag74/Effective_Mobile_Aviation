package com.example.data.search

import com.example.data.network.NetworkDataSource
import com.example.domain.model.Ticket
import com.example.domain.search.SearchRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchRepositoryImpl(
    private val networkDataSource: NetworkDataSource,
) : SearchRepository {

    override fun getDirectFlights(): Flow<List<Ticket>> = flow {
        val response = networkDataSource.doRequest(DirectFlightsRequest())
        when (response.resultCode) {
            200 -> {
                emit((response as DirectFlightsResponse).ticketsOffers.map { ticketDtoModel ->
                    Ticket(
                        id = ticketDtoModel.id,
                        title = ticketDtoModel.title,
                        timeRange = ticketDtoModel.timeRange,
                        price = ticketDtoModel.price
                    )
                })
            }
        }
    }
}