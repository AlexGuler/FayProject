package com.example.fayproject.coreui.drawables

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val FayIcons.VideoCamera: ImageVector
    get() {
        if (_videoCamera != null) return _videoCamera!!
        
        _videoCamera = ImageVector.Builder(
            name = "videoCamera",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(
                stroke = SolidColor(Color(0xFFFFFFFF)),
                strokeLineWidth = 1.25f
            ) {
                moveTo(14.1667f, 11.1806f)
                curveTo(14.1667f, 11.5066f, 14.1667f, 11.6695f, 14.2193f, 11.8104f)
                curveTo(14.2657f, 11.9349f, 14.3413f, 12.0465f, 14.4396f, 12.1359f)
                curveTo(14.5509f, 12.237f, 14.7022f, 12.2975f, 15.0048f, 12.4186f)
                lineTo(16.5048f, 13.0186f)
                curveTo(17.1174f, 13.2636f, 17.4237f, 13.3861f, 17.6696f, 13.335f)
                curveTo(17.8846f, 13.2904f, 18.0733f, 13.1626f, 18.1946f, 12.9796f)
                curveTo(18.3334f, 12.7703f, 18.3334f, 12.4404f, 18.3334f, 11.7806f)
                verticalLineTo(8.60492f)
                curveTo(18.3334f, 7.83413f, 18.3334f, 7.44873f, 18.1717f, 7.22861f)
                curveTo(18.0308f, 7.03667f, 17.8145f, 6.91419f, 17.5774f, 6.89209f)
                curveTo(17.3054f, 6.86675f, 16.975f, 7.06503f, 16.314f, 7.4616f)
                lineTo(14.814f, 8.3616f)
                curveTo(14.578f, 8.50323f, 14.4599f, 8.57405f, 14.3742f, 8.67155f)
                curveTo(14.2983f, 8.75783f, 14.2411f, 8.85887f, 14.2062f, 8.96832f)
                curveTo(14.1667f, 9.092f, 14.1667f, 9.22964f, 14.1667f, 9.50492f)
                verticalLineTo(11.1806f)
                close()
            }
            path(
                stroke = SolidColor(Color(0xFFFFFFFF)),
                strokeLineWidth = 1.25f
            ) {
                moveTo(1.66669f, 8.66667f)
                curveTo(1.66669f, 6.79983f, 1.66669f, 5.86641f, 2.03f, 5.15337f)
                curveTo(2.34958f, 4.52616f, 2.85951f, 4.01623f, 3.48672f, 3.69665f)
                curveTo(4.19976f, 3.33334f, 5.13318f, 3.33334f, 7.00002f, 3.33334f)
                horizontalLineTo(8.83335f)
                curveTo(10.7002f, 3.33334f, 11.6336f, 3.33334f, 12.3467f, 3.69665f)
                curveTo(12.9739f, 4.01623f, 13.4838f, 4.52616f, 13.8034f, 5.15337f)
                curveTo(14.1667f, 5.86641f, 14.1667f, 6.79983f, 14.1667f, 8.66667f)
                verticalLineTo(11.3333f)
                curveTo(14.1667f, 13.2002f, 14.1667f, 14.1336f, 13.8034f, 14.8466f)
                curveTo(13.4838f, 15.4738f, 12.9739f, 15.9838f, 12.3467f, 16.3034f)
                curveTo(11.6336f, 16.6667f, 10.7002f, 16.6667f, 8.83335f, 16.6667f)
                horizontalLineTo(7.00002f)
                curveTo(5.13318f, 16.6667f, 4.19976f, 16.6667f, 3.48672f, 16.3034f)
                curveTo(2.85951f, 15.9838f, 2.34958f, 15.4738f, 2.03f, 14.8466f)
                curveTo(1.66669f, 14.1336f, 1.66669f, 13.2002f, 1.66669f, 11.3333f)
                verticalLineTo(8.66667f)
                close()
            }
        }.build()
        
        return _videoCamera!!
    }

private var _videoCamera: ImageVector? = null

