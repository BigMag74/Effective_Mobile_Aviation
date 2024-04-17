package com.example.effectivemobileaviation.presentation.airTickets

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.airTickets.useCases.GetFlyAwayMusicallyItemsUseCase
import com.example.domain.model.FlyAwayMusicallyModel
import kotlinx.coroutines.launch

class AirTicketsViewModel(
    private val getFlyAwayMusicallyItemsUseCase: GetFlyAwayMusicallyItemsUseCase
) : ViewModel() {

    private val _flyAwayMusicallyItemsState = MutableLiveData<List<FlyAwayMusicallyModel>>()
    val flyAwayMusicallyItemsState: LiveData<List<FlyAwayMusicallyModel>> = _flyAwayMusicallyItemsState

    init {
        viewModelScope.launch {
            getFlyAwayMusicallyItemsUseCase.execute().collect {
                _flyAwayMusicallyItemsState.value = it
            }
        }
    }
}