package com.example.effectivemobileaviation.presentation.allTickets

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.allTickets.useCases.GetAllTicketsUseCase
import com.example.domain.model.TicketFullInfo
import kotlinx.coroutines.launch

class AllTicketsFragmentViewModel(
    private val getAllTicketsUseCase: GetAllTicketsUseCase
) : ViewModel() {

    private val _ticketsState = MutableLiveData<List<TicketFullInfo>>()
    val ticketsState: LiveData<List<TicketFullInfo>> = _ticketsState

    init {
        getTickets()
    }

    private fun getTickets() {
        viewModelScope.launch {
            getAllTicketsUseCase.execute().collect {
                _ticketsState.value = it
            }
        }
    }
}