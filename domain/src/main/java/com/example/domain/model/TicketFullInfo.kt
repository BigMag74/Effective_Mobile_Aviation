package com.example.domain.model

data class TicketFullInfo(
    val id: Int,
    val badge: String?,
    val price: Price,
    val departure: DepartureAndArrival,
    val arrival: DepartureAndArrival,
    val hasTransfer: Boolean,
) : ListItem
