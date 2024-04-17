package com.example.data.db

interface DataBaseDataSource {

    fun saveLastSearch(text: String)

    fun getLastSearch(): String
}