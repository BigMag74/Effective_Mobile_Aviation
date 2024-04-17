package com.example.data.db

import android.content.SharedPreferences

class DataBaseDataSourceImpl(private val sharedPreferences: SharedPreferences) : DataBaseDataSource {

    override fun saveLastSearch(text: String) {
        sharedPreferences.edit().putString(LAST_SEARCH_KEY, text).apply()
    }

    override fun getLastSearch(): String {
        return sharedPreferences.getString(LAST_SEARCH_KEY, "") ?: ""
    }

    companion object {

        const val LAST_SEARCH_KEY = "last search key"
    }
}