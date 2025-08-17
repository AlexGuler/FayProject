package com.example.fayproject.ui.appointments

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fayproject.R
import com.example.fayproject.coreui.drawables.FayIcons
import com.example.fayproject.coreui.drawables.VideoCamera

@Composable
fun AppointmentsList(
    modifier: Modifier = Modifier,
    appointments: List<AppointmentUiItem>,
    onJoinAppointment: (AppointmentUiItem) -> Unit
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        itemsIndexed(
            items = appointments,
            key = { _, item -> item.appointmentId }
        ) { index, item ->
            val canJoin = item.appointmentType == AppointmentType.UPCOMING && index == 0
            AppointmentCard(
                canJoin = canJoin,
                item = item,
                onJoinAppointment = onJoinAppointment
            )
        }
    }
}

@Composable
fun JoinAppointmentButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    val joinAppointment = stringResource(R.string.join_appointment)
    Button(
        onClick = onClick,
        modifier = modifier
            .semantics(mergeDescendants = true) {
                contentDescription = joinAppointment
            }
            .fillMaxWidth()
            .heightIn(
                min = 44.dp
            ),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp,
            disabledElevation = 0.dp,
            hoveredElevation = 0.dp,
            focusedElevation = 0.dp
        ),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colorScheme.primary
        )
    ) {
        Icon(
            imageVector = FayIcons.VideoCamera,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.inversePrimary,
            modifier = Modifier.size(20.dp)
        )
        Spacer(Modifier.size(8.dp))
        Text(
            text = joinAppointment,
            color = MaterialTheme.colorScheme.inversePrimary,
            style = MaterialTheme.typography.bodyMedium.copy(
                fontWeight = FontWeight.Bold
            )
        )
    }
}

@Composable
private fun AppointmentCard(
    modifier: Modifier = Modifier,
    canJoin: Boolean,
    item: AppointmentUiItem,
    onJoinAppointment: (AppointmentUiItem) -> Unit
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor =    if (canJoin) {
                MaterialTheme.colorScheme.onBackground
            } else {
                MaterialTheme.colorScheme.background
            }
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = if (canJoin) {
                4.dp
            } else {
                0.dp
            }
        ),
        border = if (canJoin) {
            null
        } else {
            BorderStroke(
                width = 1.dp,
                color = MaterialTheme.colorScheme.scrim,
            )
        },
    ) {
        AppointmentContent(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            item = item
        )

        if (canJoin) {
            JoinAppointmentButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
                onClick = {
                    onJoinAppointment.invoke(item)
                }
            )
        }
    }
}


@Composable
private fun AppointmentContent(
    modifier: Modifier = Modifier,
    item: AppointmentUiItem
) {
    Row(
        modifier = modifier
    ) {
        CalendarDay(
            appointmentType = item.appointmentType,
            month = item.month,
            day = item.day
        )

        Spacer(Modifier.size(16.dp))

        Column(
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Text(
                text = item.title,
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.Bold
                )
            )

            Text(
                text = item.subtitle,
                color = MaterialTheme.colorScheme.tertiary,
                style = MaterialTheme.typography.bodySmall.copy(
                    fontWeight = FontWeight.Medium
                )
            )
        }
    }
}

@Composable
private fun CalendarDay(
    appointmentType: AppointmentType,
    modifier: Modifier = Modifier,
    month: String,
    day: String
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(3.6.dp))
            .size(
                width = 48.dp,
                height = 48.dp,
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val textColor = when (appointmentType) {
            AppointmentType.UPCOMING -> MaterialTheme.colorScheme.primary
            AppointmentType.PAST -> MaterialTheme.colorScheme.secondary
        }
        val headerColor = when (appointmentType) {
            AppointmentType.UPCOMING -> MaterialTheme.colorScheme.surfaceTint
            AppointmentType.PAST -> MaterialTheme.colorScheme.surfaceVariant
        }

        Text(
            text = month,
            color = textColor,
            style = MaterialTheme.typography.bodySmall.copy(
                fontWeight = FontWeight.SemiBold
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .background(headerColor)
                .fillMaxWidth()
        )

        Box(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.surfaceDim)
                .fillMaxWidth()
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = day,
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )
        }
    }
}
