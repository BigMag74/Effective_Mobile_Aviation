package com.example.effectivemobileaviation.util

fun convertListToString(list: List<String>): String {
    var res = ""
    list.forEach {
        res += "$it "
    }
    res.drop(1)
    return res
}