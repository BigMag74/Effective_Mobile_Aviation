package com.example.effectivemobileaviation.util

fun convertMonthIdToString(id: Int): String {
    return when (id) {
        0 -> {"янв"}
        1 -> {"фев"}
        2 -> {"мар"}
        3 -> {"апр"}
        4 -> {"мая"}
        5 -> {"июн"}
        6 -> {"июл"}
        7 -> {"авг"}
        8 -> {"сен"}
        9 -> {"окт"}
        10 -> {"ноя"}
        else -> {"дек"}
    }
}

fun convertDayOfTheWeekIdToString(id: Int): String {
    return when(id){
        1->{"вс"}
        2->{"пн"}
        3->{"вт"}
        4->{"ср"}
        5->{"чт"}
        6->{"пт"}
        else ->{"сб"}
    }
}