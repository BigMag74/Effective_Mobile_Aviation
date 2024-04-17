package com.example.effectivemobileaviation.util

import com.example.domain.model.Price

fun convertPriceToString(price: Price): String {
    val firstPartOfNumber = (price.value / 1000)
    var secondPartOfNumber = (price.value % 1000).toString()
    while (secondPartOfNumber.length < 3) {
        secondPartOfNumber += "0"
    }
    return "от $firstPartOfNumber $secondPartOfNumber ₽"
}