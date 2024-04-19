package com.example.domain.airTickets.useCases

import com.example.domain.model.FlyAwayMusicallyModel
import kotlinx.coroutines.flow.Flow

interface GetFlyAwayMusicallyItemsUseCase {

    fun execute(): Flow<List<FlyAwayMusicallyModel>>
}