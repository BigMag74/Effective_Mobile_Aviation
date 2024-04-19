package com.example.effectivemobileaviation.presentation.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.PopularDirectionModel
import com.example.domain.search.useCases.GetDirectFlightsUseCase
import com.example.effectivemobileaviation.util.convertDayOfTheWeekIdToString
import com.example.effectivemobileaviation.util.convertMonthIdToStringShort
import kotlinx.coroutines.launch
import java.util.Calendar

class SearchViewModel(
    private val getDirectFlightsUseCase: GetDirectFlightsUseCase
) : ViewModel() {

    private val _state = MutableLiveData<SearchState>()
    val state: LiveData<SearchState> = _state

    private val _departureDateState = MutableLiveData<Pair<String, String>>()
    val departureDateState: LiveData<Pair<String, String>> = _departureDateState

    var departureMonth: Int = 0
    var departureDay: Int = 1

    private val popularDirections = listOf(
        PopularDirectionModel("Стамбул", 1),
        PopularDirectionModel("Сочи", 2),
        PopularDirectionModel("Пхукет", 3),
    )

    init {
        setEmptyState()
        initDepartureDate()
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

    private fun initDepartureDate() {
        val calendar = Calendar.getInstance()
        setDepartureDateStateByCalendar(calendar)
    }

    fun setDepartureDate(year: Int, month: Int, dayOfMonth: Int) {
        val calendar = Calendar.getInstance()
        calendar.set(year, month, dayOfMonth)
        setDepartureDateStateByCalendar(calendar)
    }

    private fun setDepartureDateStateByCalendar(calendar: Calendar) {
        val currentNumber = calendar.get(Calendar.DAY_OF_MONTH)
        departureDay = currentNumber
        val currentMonth = calendar.get(Calendar.MONTH)
        departureMonth = currentMonth
        val currentMonthString = convertMonthIdToStringShort(currentMonth)
        val currentDayOfTheWeek = convertDayOfTheWeekIdToString(calendar.get(Calendar.DAY_OF_WEEK))
        _departureDateState.value = Pair("$currentNumber $currentMonthString", ", $currentDayOfTheWeek")
    }

    private fun setState(state: SearchState) {
        _state.value = state
    }
}