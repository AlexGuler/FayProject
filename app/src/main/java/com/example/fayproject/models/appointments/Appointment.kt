package com.example.fayproject.models.appointments

import com.example.fayproject.util.ZonedDateTimeIso8601Serializer
import java.time.ZonedDateTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Appointment(
    @SerialName("appointment_id")
    val appointmentId: String,

    @SerialName("patient_id")
    val patientId: String,

    @SerialName("provider_id")
    val providerId: String,

    @SerialName("status")
    val status: String,

    @SerialName("appointment_type")
    val appointmentType: String,

    @SerialName("start")
    @Serializable(with = ZonedDateTimeIso8601Serializer::class)
    val start: ZonedDateTime,

    @SerialName("end")
    @Serializable(with = ZonedDateTimeIso8601Serializer::class)
    val end: ZonedDateTime,

    @SerialName("duration_in_minutes")
    val durationInMinutes: Int,

    @SerialName("recurrence_type")
    val recurrenceType: String
)
