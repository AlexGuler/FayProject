package com.example.fayproject.coreui.drawables

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val FayIcons.CalendarPressed: ImageVector
    get() {
        if (_calendarPressed != null) return _calendarPressed!!
        
        _calendarPressed = ImageVector.Builder(
            name = "calendarPressed",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF6874E8)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(16f, 1.25f)
                curveTo(16.4142f, 1.25f, 16.75f, 1.58579f, 16.75f, 2f)
                verticalLineTo(3.36133f)
                curveTo(17.4526f, 3.44463f, 18.0559f, 3.59446f, 18.6104f, 3.87695f)
                curveTo(19.6923f, 4.42822f, 20.5718f, 5.30773f, 21.123f, 6.38965f)
                curveTo(21.4584f, 7.04778f, 21.6078f, 7.77513f, 21.6797f, 8.65527f)
                curveTo(21.7509f, 9.5266f, 21.75f, 10.6124f, 21.75f, 12f)
                verticalLineTo(14f)
                curveTo(21.75f, 15.3876f, 21.7509f, 16.4734f, 21.6797f, 17.3447f)
                curveTo(21.6078f, 18.2249f, 21.4584f, 18.9522f, 21.123f, 19.6104f)
                curveTo(20.5718f, 20.6923f, 19.6923f, 21.5718f, 18.6104f, 22.123f)
                curveTo(17.9522f, 22.4584f, 17.2249f, 22.6078f, 16.3447f, 22.6797f)
                curveTo(15.4734f, 22.7509f, 14.3876f, 22.75f, 13f, 22.75f)
                horizontalLineTo(11f)
                curveTo(9.61244f, 22.75f, 8.5266f, 22.7509f, 7.65527f, 22.6797f)
                curveTo(6.77513f, 22.6078f, 6.04778f, 22.4584f, 5.38965f, 22.123f)
                curveTo(4.30774f, 21.5718f, 3.42822f, 20.6923f, 2.87695f, 19.6104f)
                curveTo(2.54162f, 18.9522f, 2.39222f, 18.2249f, 2.32031f, 17.3447f)
                curveTo(2.24915f, 16.4734f, 2.25f, 15.3876f, 2.25f, 14f)
                verticalLineTo(12f)
                curveTo(2.25f, 10.6124f, 2.24915f, 9.5266f, 2.32031f, 8.65527f)
                curveTo(2.39222f, 7.77513f, 2.54162f, 7.04778f, 2.87695f, 6.38965f)
                curveTo(3.42822f, 5.30773f, 4.30774f, 4.42822f, 5.38965f, 3.87695f)
                curveTo(5.94407f, 3.59446f, 6.54742f, 3.44463f, 7.25f, 3.36133f)
                verticalLineTo(2f)
                curveTo(7.25f, 1.58579f, 7.58579f, 1.25f, 8f, 1.25f)
                curveTo(8.41421f, 1.25f, 8.75f, 1.58579f, 8.75f, 2f)
                verticalLineTo(3.26855f)
                curveTo(9.39824f, 3.25186f, 10.1413f, 3.25f, 11f, 3.25f)
                horizontalLineTo(13f)
                curveTo(13.8587f, 3.25f, 14.6018f, 3.25186f, 15.25f, 3.26855f)
                verticalLineTo(2f)
                curveTo(15.25f, 1.58579f, 15.5858f, 1.25f, 16f, 1.25f)
                close()
                moveTo(8f, 8.75f)
                curveTo(7.58579f, 8.75f, 7.25f, 9.08579f, 7.25f, 9.5f)
                curveTo(7.25f, 9.91421f, 7.58579f, 10.25f, 8f, 10.25f)
                horizontalLineTo(16f)
                curveTo(16.4142f, 10.25f, 16.75f, 9.91421f, 16.75f, 9.5f)
                curveTo(16.75f, 9.08579f, 16.4142f, 8.75f, 16f, 8.75f)
                horizontalLineTo(8f)
                close()
            }
        }.build()
        
        return _calendarPressed!!
    }

private var _calendarPressed: ImageVector? = null

