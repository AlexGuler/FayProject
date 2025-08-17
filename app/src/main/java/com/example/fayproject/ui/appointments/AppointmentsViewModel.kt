package com.example.fayproject.ui.appointments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fayproject.models.ObservableData
import com.example.fayproject.models.appointments.Appointment
import com.example.fayproject.repository.AppointmentsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.*
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import timber.log.Timber

@HiltViewModel
class AppointmentsViewModel @Inject constructor(
    private val appointmentsRepository: AppointmentsRepository,
) : ViewModel() {

    private val _state = MutableStateFlow(AppointmentsUiState())
    val state = _state.asStateFlow()

    init {
        getAppointments()
    }

    fun onJoinAppointment(item: AppointmentUiItem) {
        // TODO: handle joining an appointment
    }

    fun onNewAppointment() {
        // TODO: handle on new appointment
    }

    fun getAppointments() {
        viewModelScope.launch {
            appointmentsRepository.fetchAppointments()
                .map {
                    when (it) {
                        is ObservableData.Data<List<Appointment>> -> {
                            val (upcomingAppointments, pastAppointments) = it.data.toUpcomingAndPastAppointments()
                            state.value.copy(
                                upcomingAppointments = ObservableData.Data(upcomingAppointments),
                                pastAppointments = ObservableData.Data(pastAppointments),
                            )
                        }

                        is ObservableData.Error -> {
                            Timber.e(it.error, "Error trying to get appointments")
                            state.value.copy(
                                upcomingAppointments = ObservableData.Error(it.error),
                                pastAppointments = ObservableData.Error(it.error)
                            )
                        }

                        ObservableData.Loading -> {
                            state.value.copy(
                                upcomingAppointments = ObservableData.Loading,
                                pastAppointments = ObservableData.Loading
                            )
                        }
                    }
                }.collect(_state)
        }
    }

//    private fun List<Appointment>.toUpcomingAndPastAppointments(): Pair<List<Appointment>, List<Appointment>> {
//        val now = ZonedDateTime.now()
//        val (upcomingRaw, pastRaw) = partition { it.end.isAfter(now) } // end > now => upcoming
//        val upcoming = upcomingRaw.sortedBy { it.start }
//        val past = pastRaw.sortedByDescending { it.start }
//        return upcoming to past
//    }


    private fun List<Appointment>.toUpcomingAndPastAppointments(
        userZone: ZoneId = ZoneId.systemDefault()
    ): Pair<List<AppointmentUiItem>, List<AppointmentUiItem>> {

        val now = Instant.now()
        val (upcomingRaw, pastRaw) = partition { it.end.toInstant().isAfter(now) }

        val upcomingItems = upcomingRaw
            .sortedBy { it.start.toInstant() }
            .map { it.toUiItem(AppointmentType.UPCOMING, userZone) }
            .toMutableList()

        if (upcomingItems.isNotEmpty()) {
            val first = upcomingItems.first()
            upcomingItems[0] = first.copy(subtitle = first.subtitle + " with Jane Williams")
        }

        val pastItems = pastRaw
            .sortedByDescending { it.start.toInstant() }
            .map { it.toUiItem(AppointmentType.PAST, userZone) }

        return upcomingItems to pastItems
    }

    private fun Appointment.toUiItem(
        type: AppointmentType,
        userZone: ZoneId
    ): AppointmentUiItem {
        val startLocal = start.withZoneSameInstant(userZone)
        val endLocal = end.withZoneSameInstant(userZone)

        val timeFmt = DateTimeFormatter.ofPattern("h:mm a", Locale.US)
        val tzAbbrev = startLocal.zone.getDisplayName(TextStyle.SHORT, Locale.US) // e.g., PDT/CDT/UTC

        val title = "${startLocal.format(timeFmt)} – ${endLocal.format(timeFmt)} ($tzAbbrev)"
        val month = startLocal.month.getDisplayName(TextStyle.SHORT, Locale.US).uppercase(Locale.US)
        val day = "%02d".format(startLocal.dayOfMonth)

        return AppointmentUiItem(
            appointmentId = appointmentId,
            title = title,
            subtitle = appointmentType, // keep exactly as provided
            month = month,
            day = day,
            appointmentType = type
        )
    }
}

data class AppointmentsUiState(
    val upcomingAppointments: ObservableData<List<AppointmentUiItem>> = ObservableData.Loading,
    val pastAppointments: ObservableData<List<AppointmentUiItem>> = ObservableData.Loading,
//    val tabSelected: Int = 0
) {

    val isLoading: Boolean get() = upcomingAppointments == ObservableData.Loading ||
        pastAppointments == ObservableData.Loading

}

data class AppointmentUiItem(
    val appointmentId: String,
    val title: String,
    val subtitle: String,
    val month: String,
    val day: String,
    val appointmentType: AppointmentType
)

enum class AppointmentType {
    UPCOMING,
    PAST
}
