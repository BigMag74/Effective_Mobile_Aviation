package com.example.domain.airTickets

import com.example.domain.model.FlyAwayMusicallyModel
import kotlinx.coroutines.flow.Flow

interface AirTicketsRepository {

    fun getFlyAwayMusicallyItems(): Flow<List<FlyAwayMusicallyModel>>
}