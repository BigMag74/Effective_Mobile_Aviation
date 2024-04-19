package com.example.domain.allTickets

import com.example.domain.model.TicketFullInfo
import kotlinx.coroutines.flow.Flow

interface AllTicketsRepository {

    fun getAllTickets(): Flow<List<TicketFullInfo>>
}