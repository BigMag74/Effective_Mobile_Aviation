package com.example.domain.search.useCases

import com.example.domain.model.Ticket
import kotlinx.coroutines.flow.Flow

interface GetDirectFlightsUseCase {

    fun execute(): Flow<List<Ticket>>
}