package com.example.domain.airTickets.useCases.impl

import com.example.domain.airTickets.AirTicketsRepository
import com.example.domain.airTickets.useCases.GetFlyAwayMusicallyItemsUseCase
import com.example.domain.model.FlyAwayMusicallyModel
import kotlinx.coroutines.flow.Flow

class GetFlyAwayMusicallyItemsUseCaseImpl(
    private val repository: AirTicketsRepository,
) : GetFlyAwayMusicallyItemsUseCase {

    override fun execute(): Flow<List<FlyAwayMusicallyModel>> {
        return repository.getFlyAwayMusicallyItems()
    }
}