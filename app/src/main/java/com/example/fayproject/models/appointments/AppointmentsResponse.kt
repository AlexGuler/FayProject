package com.example.fayproject.models.appointments

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AppointmentsResponse(
    @SerialName("appointments")
    val appointments: List<Appointment>
)
