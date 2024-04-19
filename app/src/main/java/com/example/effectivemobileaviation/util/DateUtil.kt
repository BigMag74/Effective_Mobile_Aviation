package com.example.effectivemobileaviation.util

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

fun convertMonthIdToString(id: Int): String {
    return when (id) {
        0 -> {
            "янв"
        }

        1 -> {
            "фев"
        }

        2 -> {
            "мар"
        }

        3 -> {
            "апр"
        }

        4 -> {
            "мая"
        }

        5 -> {
            "июн"
        }

        6 -> {
            "июл"
        }

        7 -> {
            "авг"
        }

        8 -> {
            "сен"
        }

        9 -> {
            "окт"
        }

        10 -> {
            "ноя"
        }

        else -> {
            "дек"
        }
    }
}

fun convertDayOfTheWeekIdToString(id: Int): String {
    return when (id) {
        1 -> {
            "вс"
        }

        2 -> {
            "пн"
        }

        3 -> {
            "вт"
        }

        4 -> {
            "ср"
        }

        5 -> {
            "чт"
        }

        6 -> {
            "пт"
        }

        else -> {
            "сб"
        }
    }
}

fun getTimeFromDate(dateString: String): String {
    val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
    val date = sdf.parse(dateString)
    val calendar = Calendar.getInstance()
    if (date != null) {
        calendar.time = date
    }
    return "${calendar.get(Calendar.HOUR)}:${calendar.get(Calendar.MINUTE)}"
}

fun calculateFlightTime(departureTime: String, arrivalTime: String): String {
    val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
    val departureDate = sdf.parse(departureTime)
    val arrivalDate = sdf.parse(arrivalTime)
    val departureCalendar = Calendar.getInstance()
    if (departureDate != null) {
        departureCalendar.time = departureDate
    }
    val arrivalCalendar = Calendar.getInstance()
    if (arrivalDate != null) {
        arrivalCalendar.time = arrivalDate
    }
    val difference: Float = (arrivalCalendar.timeInMillis - departureCalendar.timeInMillis).toFloat()

    return String.format("%.1f", difference / (1000 * 60 * 60))
}