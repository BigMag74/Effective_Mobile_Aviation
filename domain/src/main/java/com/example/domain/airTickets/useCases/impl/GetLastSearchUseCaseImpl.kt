package com.example.domain.airTickets.useCases.impl

import com.example.domain.airTickets.AirTicketsRepository
import com.example.domain.airTickets.useCases.GetLastSearchUseCase

class GetLastSearchUseCaseImpl(
    private val repository: AirTicketsRepository
) : GetLastSearchUseCase {

    override fun execute(): String {
        return repository.getLastSearch()
    }
}