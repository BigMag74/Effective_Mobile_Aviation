package com.example.domain.model

data class Ticket(
    val id: Int,
    val title: String,
    val timeRange: List<String>,
    val price: Price
) : ListItem