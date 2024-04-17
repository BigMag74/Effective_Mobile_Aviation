package com.example.data.network

interface NetworkDataSource {

    suspend fun doRequest(dto: Any): Response
}