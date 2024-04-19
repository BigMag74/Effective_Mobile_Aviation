package com.example.data.network

import android.content.Context
import com.example.data.R
import com.example.data.airTickets.FlyAwayMusicallyRequest
import com.example.data.airTickets.FlyAwayMusicallyResponse
import com.example.data.allTickets.AllTicketsRequest
import com.example.data.allTickets.AllTicketsResponse
import com.example.data.search.DirectFlightsRequest
import com.example.data.search.DirectFlightsResponse
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NetworkDataSourceImpl(
    private val context: Context,
) : NetworkDataSource {

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
        }
        if (dto is DirectFlightsRequest) {
            return withContext(Dispatchers.IO) {
                try {
                    val jsonElement =
                        context.resources.openRawResource(R.raw.offers_tickets).bufferedReader().use { it.readText() }
                    val response = Gson().fromJson(jsonElement, DirectFlightsResponse::class.java)
                    response.apply { resultCode = 200 }
                } catch (e: Throwable) {
                    Response().apply { resultCode = 500 }
                }
            }
        }
        if (dto is AllTicketsRequest) {
            return withContext(Dispatchers.IO) {
                try {
                    val jsonElement =
                        context.resources.openRawResource(R.raw.tickets).bufferedReader().use { it.readText() }
                    val response = Gson().fromJson(jsonElement, AllTicketsResponse::class.java)
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