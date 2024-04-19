package com.example.domain.allTickets.useCases.impl

import com.example.domain.allTickets.AllTicketsRepository
import com.example.domain.allTickets.useCases.GetAllTicketsUseCase
import com.example.domain.model.TicketFullInfo
import kotlinx.coroutines.flow.Flow

class GetAllTicketsUseCaseImpl(
    private val repository: AllTicketsRepository
) : GetAllTicketsUseCase {

    override fun execute(): Flow<List<TicketFullInfo>> {
        return repository.getAllTickets()
    }
}