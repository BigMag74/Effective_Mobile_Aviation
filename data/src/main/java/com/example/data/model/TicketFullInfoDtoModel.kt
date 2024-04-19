package com.example.data.model

import com.example.domain.model.DepartureAndArrival
import com.example.domain.model.Price
import com.google.gson.annotations.SerializedName

data class TicketFullInfoDtoModel(
    val id: Int,
    val badge: String?,
    val price: Price,
    val departure: DepartureAndArrival,
    val arrival: DepartureAndArrival,
    @SerializedName("has_transfer")
    val hasTransfer: Boolean,
)