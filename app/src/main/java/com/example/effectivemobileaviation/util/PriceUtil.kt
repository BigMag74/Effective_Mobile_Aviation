package com.example.effectivemobileaviation.util

import com.example.domain.model.Price

fun convertPriceToString(price: Price): String {
    val startString = "от ${(price.value / 1000)} "
    val endString = "${(price.value % 1000)} ₽"
    return startString + endString
}