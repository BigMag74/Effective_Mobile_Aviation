package com.example.effectivemobileaviation.presentation.search

import com.example.domain.model.PopularDirectionModel
import com.example.domain.model.Ticket

sealed interface SearchState {
    data class EmptyCountryTo(val content: List<PopularDirectionModel>) : SearchState
    data class FilledCountryTo(val content: List<Ticket>) : SearchState
}