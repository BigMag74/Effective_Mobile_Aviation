package com.example.domain.allTickets.useCases

import com.example.domain.model.TicketFullInfo
import kotlinx.coroutines.flow.Flow

interface GetAllTicketsUseCase {

    fun execute(): Flow<List<TicketFullInfo>>
}