package com.example.effectivemobileaviation.presentation.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.PopularDirectionModel
import com.example.domain.search.useCases.GetDirectFlightsUseCase
import kotlinx.coroutines.launch

class SearchViewModel(
    private val getDirectFlightsUseCase: GetDirectFlightsUseCase
) : ViewModel() {

    private val _state = MutableLiveData<SearchState>()
    val state: LiveData<SearchState> = _state

    private val popularDirections = listOf(
        PopularDirectionModel("Стамбул", 1),
        PopularDirectionModel("Сочи", 2),
        PopularDirectionModel("Пхукет", 3),
    )

    init {
        setEmptyState()
    }

    fun setFilledState() {
        viewModelScope.launch {
            getDirectFlightsUseCase.execute().collect {
                setState(SearchState.FilledCountryTo(it))
            }
        }
    }

    fun setEmptyState() {
        setState(SearchState.EmptyCountryTo(popularDirections))
    }

    private fun setState(state: SearchState) {
        _state.value = state
    }
}