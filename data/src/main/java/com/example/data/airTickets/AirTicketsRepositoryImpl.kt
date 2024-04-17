package com.example.data.airTickets

import com.example.data.network.DataSource
import com.example.domain.airTickets.AirTicketsRepository
import com.example.domain.model.FlyAwayMusicallyModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AirTicketsRepositoryImpl(
    private val dataSource: DataSource
) : AirTicketsRepository {

    override fun getFlyAwayMusicallyItems(): Flow<List<FlyAwayMusicallyModel>> = flow {
        val response = dataSource.doRequest(FlyAwayMusicallyRequest())
        when (response.resultCode) {
            200 -> {
                emit((response as FlyAwayMusicallyResponse).offers)
            }
        }
    }
}