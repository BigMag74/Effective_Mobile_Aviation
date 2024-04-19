package com.example.domain.airTickets.useCases.impl

import com.example.domain.airTickets.AirTicketsRepository
import com.example.domain.airTickets.useCases.SaveLastSearchUseCase

class SaveLastSearchUseCaseImpl(private val repository: AirTicketsRepository) : SaveLastSearchUseCase {

    override fun execute(text: String) {
        repository.saveLastSearch(text)
    }
}