package com.example.data.model

import com.example.domain.model.Price
import com.google.gson.annotations.SerializedName

data class TicketDtoModel(
    val id: Int,
    val title: String,
    @SerializedName("time_range")
    val timeRange: List<String>,
    val price: Price
)
