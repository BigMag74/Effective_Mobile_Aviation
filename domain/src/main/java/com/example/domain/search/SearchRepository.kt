package com.example.domain.search

import com.example.domain.model.Ticket
import kotlinx.coroutines.flow.Flow

interface SearchRepository {

    fun getDirectFlights(): Flow<List<Ticket>>
}