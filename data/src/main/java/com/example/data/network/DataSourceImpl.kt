package com.example.data.network

import android.content.Context
import com.example.data.R
import com.example.data.airTickets.FlyAwayMusicallyRequest
import com.example.data.airTickets.FlyAwayMusicallyResponse
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DataSourceImpl(
    private val context: Context,
) : DataSource {

    override suspend fun doRequest(dto: Any): Response {

        if (dto is FlyAwayMusicallyRequest) {
            return withContext(Dispatchers.IO) {
                try {
                    val jsonElement =
                        context.resources.openRawResource(R.raw.offers).bufferedReader().use { it.readText() }
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