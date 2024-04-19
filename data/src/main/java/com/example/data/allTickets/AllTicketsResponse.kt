package com.example.data.allTickets

import com.example.data.model.TicketFullInfoDtoModel
import com.example.data.network.Response

class AllTicketsResponse(val tickets: List<TicketFullInfoDtoModel>) : Response() {
}