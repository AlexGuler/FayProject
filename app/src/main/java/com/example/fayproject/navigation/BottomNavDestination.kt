package com.example.fayproject.navigation

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.fayproject.R
import com.example.fayproject.coreui.drawables.Calendar
import com.example.fayproject.coreui.drawables.Chat
import com.example.fayproject.coreui.drawables.FayIcons
import com.example.fayproject.coreui.drawables.Journal
import com.example.fayproject.coreui.drawables.Profile
import kotlin.reflect.KClass

enum class BottomNavDestination(
    val icon: ImageVector,
    @StringRes val iconTextId: Int,
    val route: KClass<*>,
) {
    APPOINTMENTS(
        icon = FayIcons.Calendar,
        iconTextId = R.string.appointments,
        route = AppointmentsRoute::class
    ),
    CHAT(
        icon = FayIcons.Chat,
        iconTextId = R.string.chat,
        route = ChatRoute::class
    ),
    JOURNAL(
        icon = FayIcons.Journal,
        iconTextId = R.string.journal,
        route = JournalRoute::class
    ),
    PROFILE(
        icon = FayIcons.Profile,
        iconTextId = R.string.profile,
        route = ProfileRoute::class
    )
}
