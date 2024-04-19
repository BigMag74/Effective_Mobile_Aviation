package com.example.domain.model

data class FlyAwayMusicallyModel(
    val id: Int,
    val title: String,
    val town: String,
    val price: Price,
) : ListItem
