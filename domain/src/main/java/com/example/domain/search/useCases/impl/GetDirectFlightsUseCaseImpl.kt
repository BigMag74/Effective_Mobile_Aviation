package com.example.domain.search.useCases.impl

import com.example.domain.model.Ticket
import com.example.domain.search.SearchRepository
import com.example.domain.search.useCases.GetDirectFlightsUseCase
import kotlinx.coroutines.flow.Flow

class GetDirectFlightsUseCaseImpl(private val repository: SearchRepository) : GetDirectFlightsUseCase {

    override fun execute(): Flow<List<Ticket>> {
        return repository.getDirectFlights()
    }
}