package com.example.data.airTickets

import com.example.data.db.DataBaseDataSource
import com.example.data.network.NetworkDataSource
import com.example.domain.airTickets.AirTicketsRepository
import com.example.domain.model.FlyAwayMusicallyModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AirTicketsRepositoryImpl(
    private val networkDataSource: NetworkDataSource,
    private val dataBaseDataSource: DataBaseDataSource,
) : AirTicketsRepository {

    override fun getFlyAwayMusicallyItems(): Flow<List<FlyAwayMusicallyModel>> = flow {
        val response = networkDataSource.doRequest(FlyAwayMusicallyRequest())
        when (response.resultCode) {
            200 -> {
                emit((response as FlyAwayMusicallyResponse).offers)
            }
        }
    }

    override fun saveLastSearch(text: String) {
        dataBaseDataSource.saveLastSearch(text)
    }

    override fun getLastSearch(): String {
        return dataBaseDataSource.getLastSearch()
    }
}