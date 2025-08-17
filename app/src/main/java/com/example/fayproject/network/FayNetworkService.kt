package com.example.fayproject.network

import com.example.fayproject.models.appointments.AppointmentsResponse
import com.example.fayproject.models.login.LoginRequest
import com.example.fayproject.models.login.LoginResult
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface FayNetworkService {

    @POST("/signin")
    suspend fun login(@Body loginRequest: LoginRequest): Response<LoginResult>

    @GET("/appointments")
    suspend fun getAppointments(): Response<AppointmentsResponse>
}
