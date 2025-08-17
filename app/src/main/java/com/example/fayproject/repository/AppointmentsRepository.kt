package com.example.fayproject.repository

import com.example.fayproject.models.ObservableData
import com.example.fayproject.models.appointments.Appointment
import com.example.fayproject.network.FayNetworkService
import javax.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart

interface AppointmentsRepository {
    fun fetchAppointments(): Flow<ObservableData<List<Appointment>>>
}

class AppointmentsRepositoryImpl @Inject constructor(
    private val fayNetworkService: FayNetworkService
) : AppointmentsRepository {

    override fun fetchAppointments(): Flow<ObservableData<List<Appointment>>> {
        return flow<ObservableData<List<Appointment>>> {
            val response = fayNetworkService.getAppointments()
            val result = response.body()
            if (response.isSuccessful && result != null) {
                emit(ObservableData.Data(result.appointments))
            } else {
                emit(ObservableData.Error(Exception("Error occurred with code: ${response.code()}, message: ${response.errorBody()?.string()}")))
            }
        }.onStart {
            emit(ObservableData.Loading)
        }.catch { throwable ->
            emit(ObservableData.Error(throwable))
        }
    }
}
