package com.example.data.network

interface DataSource {

    suspend fun doRequest(dto: Any): Response
}