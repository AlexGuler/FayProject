package com.example.fayproject.coreui.drawables

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val FayIcons.Profile: ImageVector
    get() {
        if (_user != null) return _user!!
        
        _user = ImageVector.Builder(
            name = "user",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                fill = SolidColor(Color(0xFFFFFFFF)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(8.584f, 9.16524f)
                curveTo(8.58478f, 7.27905f, 10.1143f, 5.75f, 12.0007f, 5.75f)
                curveTo(13.8875f, 5.75f, 15.4173f, 7.27982f, 15.4173f, 9.16667f)
                curveTo(15.4173f, 11.0543f, 13.8874f, 12.5833f, 12.0007f, 12.5833f)
                horizontalLineTo(11.9811f)
                lineTo(11.9786f, 12.5833f)
                curveTo(10.0968f, 12.5771f, 8.57762f, 11.0465f, 8.584f, 9.16524f)
                close()
                moveTo(12.0007f, 7.25f)
                curveTo(10.9422f, 7.25f, 10.084f, 8.10824f, 10.084f, 9.16667f)
                lineTo(10.084f, 9.16952f)
                curveTo(10.08f, 10.2228f, 10.9299f, 11.0793f, 11.9825f, 11.0833f)
                horizontalLineTo(12.0007f)
                curveTo(13.0592f, 11.0833f, 13.9173f, 10.2257f, 13.9173f, 9.16667f)
                curveTo(13.9173f, 8.10824f, 13.0591f, 7.25f, 12.0007f, 7.25f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFFFFFFF))
            ) {
                moveTo(8.584f, 9.16524f)
                curveTo(8.58401f, 9.16476f, 8.58401f, 9.16429f, 8.58401f, 9.16381f)
                lineTo(9.334f, 9.16667f)
                horizontalLineTo(8.584f)
                curveTo(8.584f, 9.16619f, 8.584f, 9.16572f, 8.584f, 9.16524f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFFFFFFF))
            ) {
                moveTo(8.21667f, 14.9f)
                curveTo(9.19754f, 14.1644f, 10.4725f, 13.7501f, 12f, 13.75f)
                curveTo(13.5275f, 13.75f, 14.8025f, 14.1644f, 15.7833f, 14.9f)
                curveTo(16.763f, 15.6347f, 17.4054f, 16.6573f, 17.7226f, 17.7993f)
                curveTo(17.8335f, 18.1984f, 17.5998f, 18.6118f, 17.2007f, 18.7226f)
                curveTo(16.8016f, 18.8335f, 16.3882f, 18.5998f, 16.2774f, 18.2007f)
                curveTo(16.039f, 17.3427f, 15.5703f, 16.6152f, 14.8833f, 16.1f)
                curveTo(14.1975f, 15.5857f, 13.2503f, 15.25f, 12f, 15.25f)
                curveTo(10.7498f, 15.2501f, 9.80245f, 15.5857f, 9.11666f, 16.1f)
                curveTo(8.42966f, 16.6153f, 7.96098f, 17.3427f, 7.72264f, 18.2007f)
                curveTo(7.61178f, 18.5998f, 7.19837f, 18.8335f, 6.79927f, 18.7226f)
                curveTo(6.40016f, 18.6117f, 6.1665f, 18.1983f, 6.27736f, 17.7992f)
                curveTo(6.59458f, 16.6573f, 7.237f, 15.6348f, 8.21667f, 14.9f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFFFFFFF)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(1.25f, 12f)
                curveTo(1.25f, 6.06294f, 6.06294f, 1.25f, 12f, 1.25f)
                curveTo(17.9371f, 1.25f, 22.75f, 6.06294f, 22.75f, 12f)
                curveTo(22.75f, 17.9371f, 17.9371f, 22.75f, 12f, 22.75f)
                curveTo(6.06294f, 22.75f, 1.25f, 17.9371f, 1.25f, 12f)
                close()
                moveTo(12f, 2.75f)
                curveTo(6.89137f, 2.75f, 2.75f, 6.89137f, 2.75f, 12f)
                curveTo(2.75f, 17.1086f, 6.89137f, 21.25f, 12f, 21.25f)
                curveTo(17.1086f, 21.25f, 21.25f, 17.1086f, 21.25f, 12f)
                curveTo(21.25f, 6.89137f, 17.1086f, 2.75f, 12f, 2.75f)
                close()
            }
        }.build()
        
        return _user!!
    }

private var _user: ImageVector? = null

