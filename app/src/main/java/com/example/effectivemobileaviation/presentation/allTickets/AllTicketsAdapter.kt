package com.example.effectivemobileaviation.presentation.allTickets

import android.view.View
import com.example.domain.model.ListItem
import com.example.domain.model.TicketFullInfo
import com.example.effectivemobileaviation.databinding.ItemTicketBinding
import com.example.effectivemobileaviation.util.calculateFlightTime
import com.example.effectivemobileaviation.util.convertPriceToString
import com.example.effectivemobileaviation.util.getTimeFromDate
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

fun allTicketsAdapter() = adapterDelegateViewBinding<TicketFullInfo, ListItem, ItemTicketBinding>(
    { layoutInflater, root -> ItemTicketBinding.inflate(layoutInflater, root, false) }
) {
    bind {
        if (!item.badge.isNullOrEmpty()) {
            binding.badgeTV.visibility = View.VISIBLE
            binding.badgeTV.text = item.badge
        }
        binding.priceTV.text = convertPriceToString(item.price)
        binding.timeDepartureTV.text = getTimeFromDate(item.departure.date)
        binding.airportDepartureTV.text = item.departure.airport
        binding.timeArrivalTV.text = getTimeFromDate(item.arrival.date)
        binding.airportArrivalTV.text = item.arrival.airport
        if (item.hasTransfer) {
            binding.flightTime.text = calculateFlightTime(item.departure.date, item.arrival.date) + "ч в пути"
        } else {
            binding.flightTime.text = calculateFlightTime(item.departure.date, item.arrival.date) +
                    "ч в пути/Без пересадок"
        }
    }
}