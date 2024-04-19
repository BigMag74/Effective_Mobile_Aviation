package com.example.data.search

import com.example.data.model.TicketDtoModel
import com.example.data.network.Response
import com.google.gson.annotations.SerializedName

class DirectFlightsResponse(
    @SerializedName("tickets_offers")
    val ticketsOffers: List<TicketDtoModel>
): Response()