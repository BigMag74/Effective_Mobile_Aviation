package com.example.effectivemobileaviation.presentation.airTickets

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.airTickets.useCases.GetFlyAwayMusicallyItemsUseCase
import com.example.domain.airTickets.useCases.GetLastSearchUseCase
import com.example.domain.airTickets.useCases.SaveLastSearchUseCase
import com.example.domain.model.FlyAwayMusicallyModel
import kotlinx.coroutines.launch

class AirTicketsViewModel(
    private val getFlyAwayMusicallyItemsUseCase: GetFlyAwayMusicallyItemsUseCase,
    private val getLastSearchUseCase: GetLastSearchUseCase,
    private val saveLastSearchUseCase: SaveLastSearchUseCase,
) : ViewModel() {

    private val _flyAwayMusicallyItemsState = MutableLiveData<List<FlyAwayMusicallyModel>>()
    val flyAwayMusicallyItemsState: LiveData<List<FlyAwayMusicallyModel>> = _flyAwayMusicallyItemsState

    private val _lastSearchText = MutableLiveData<String>()
    val lastSearchText: LiveData<String> = _lastSearchText

    init {
        viewModelScope.launch {
            getFlyAwayMusicallyItemsUseCase.execute().collect {
                _flyAwayMusicallyItemsState.value = it
            }
        }
        _lastSearchText.value = getLastSearchText()
    }

    fun saveLastSearch(text: String) {
        saveLastSearchUseCase.execute(text)
    }

    private fun getLastSearchText(): String {
        return getLastSearchUseCase.execute()
    }
}