package com.example.data.network

import com.example.data.airTickets.FlyAwayMusicallyRequest
import com.example.data.airTickets.FlyAwayMusicallyResponse
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DataSourceImpl() : DataSource {

    override suspend fun doRequest(dto: Any): Response {

        if (dto is FlyAwayMusicallyRequest) {
            return withContext(Dispatchers.IO) {
                try {
                    val jsonElement =
                        "{\"offers\": [{\"id\": 1,\"title\": \"Die Antwoord\",\"town\": \"Будапешт\",\"price\": {\"value\": 5000 } },{\"id\": 2,\"title\": \"Socrat&Lera\",\"town\": \"Санкт-Петербург\",\"price\": {\"value\": 1999 } },{\"id\": 3,\"title\": \"Лампабикт\",\"town\": \"Москва\",\"price\": {\"value\": 2390 } }] }"
                    val response = Gson().fromJson(jsonElement, FlyAwayMusicallyResponse::class.java)
                    response.apply { resultCode = 200 }
                } catch (e: Throwable) {
                    Response().apply { resultCode = 500 }
                }
            }
        } else {
            return Response().apply { resultCode = 400 }
        }
    }
}