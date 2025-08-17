package com.example.fayproject.coreui.drawables

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val FayIcons.New: ImageVector
    get() {
        if (_new != null) return _new!!
        
        _new = ImageVector.Builder(
            name = "new",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(
                fill = SolidColor(Color(0xFFFFFFFF))
            ) {
                moveTo(8.28634f, 1.875f)
                horizontalLineTo(11.7137f)
                curveTo(13.2452f, 1.87499f, 14.4582f, 1.87498f, 15.4075f, 2.00261f)
                curveTo(16.3846f, 2.13397f, 17.1753f, 2.41073f, 17.799f, 3.03437f)
                curveTo(18.4226f, 3.65801f, 18.6994f, 4.4488f, 18.8307f, 5.42581f)
                curveTo(18.9584f, 6.37516f, 18.9584f, 7.58819f, 18.9584f, 9.11966f)
                verticalLineTo(10.8803f)
                curveTo(18.9584f, 12.4118f, 18.9584f, 13.6248f, 18.8307f, 14.5742f)
                curveTo(18.6994f, 15.5512f, 18.4226f, 16.342f, 17.799f, 16.9656f)
                curveTo(17.1753f, 17.5893f, 16.3846f, 17.866f, 15.4075f, 17.9974f)
                curveTo(14.4582f, 18.125f, 13.2452f, 18.125f, 11.7137f, 18.125f)
                horizontalLineTo(10.8334f)
                curveTo(10.4882f, 18.125f, 10.2084f, 17.8452f, 10.2084f, 17.5f)
                curveTo(10.2084f, 17.1548f, 10.4882f, 16.875f, 10.8334f, 16.875f)
                horizontalLineTo(11.6667f)
                curveTo(13.2557f, 16.875f, 14.3846f, 16.8737f, 15.241f, 16.7585f)
                curveTo(16.0794f, 16.6458f, 16.5624f, 16.4344f, 16.9151f, 16.0817f)
                curveTo(17.2678f, 15.7291f, 17.4792f, 15.246f, 17.5919f, 14.4076f)
                curveTo(17.707f, 13.5512f, 17.7084f, 12.4224f, 17.7084f, 10.8333f)
                verticalLineTo(9.16667f)
                curveTo(17.7084f, 7.57765f, 17.707f, 6.44876f, 17.5919f, 5.59237f)
                curveTo(17.4792f, 4.75397f, 17.2678f, 4.27093f, 16.9151f, 3.91825f)
                curveTo(16.5624f, 3.56558f, 16.0794f, 3.35419f, 15.241f, 3.24147f)
                curveTo(14.3846f, 3.12633f, 13.2557f, 3.125f, 11.6667f, 3.125f)
                horizontalLineTo(8.33335f)
                curveTo(6.74434f, 3.125f, 5.61545f, 3.12633f, 4.75906f, 3.24147f)
                curveTo(3.92065f, 3.35419f, 3.43762f, 3.56558f, 3.08494f, 3.91825f)
                curveTo(2.73227f, 4.27093f, 2.52087f, 4.75397f, 2.40815f, 5.59237f)
                curveTo(2.29301f, 6.44876f, 2.29169f, 7.57765f, 2.29169f, 9.16667f)
                curveTo(2.29169f, 9.51185f, 2.01187f, 9.79167f, 1.66669f, 9.79167f)
                curveTo(1.32151f, 9.79167f, 1.04169f, 9.51185f, 1.04169f, 9.16667f)
                lineTo(1.04169f, 9.11965f)
                curveTo(1.04167f, 7.58819f, 1.04166f, 6.37516f, 1.1693f, 5.42581f)
                curveTo(1.30066f, 4.4488f, 1.57742f, 3.65801f, 2.20106f, 3.03437f)
                curveTo(2.82469f, 2.41073f, 3.61548f, 2.13397f, 4.5925f, 2.00261f)
                curveTo(5.54185f, 1.87498f, 6.75487f, 1.87499f, 8.28634f, 1.875f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFFFFFFF))
            ) {
                moveTo(5.83335f, 10.2083f)
                curveTo(6.17853f, 10.2083f, 6.45835f, 10.4882f, 6.45835f, 10.8333f)
                verticalLineTo(13.5417f)
                horizontalLineTo(9.16669f)
                curveTo(9.51187f, 13.5417f, 9.79169f, 13.8215f, 9.79169f, 14.1667f)
                curveTo(9.79169f, 14.5118f, 9.51187f, 14.7917f, 9.16669f, 14.7917f)
                horizontalLineTo(6.45835f)
                verticalLineTo(17.5f)
                curveTo(6.45835f, 17.8452f, 6.17853f, 18.125f, 5.83335f, 18.125f)
                curveTo(5.48818f, 18.125f, 5.20835f, 17.8452f, 5.20835f, 17.5f)
                verticalLineTo(14.7917f)
                horizontalLineTo(2.50002f)
                curveTo(2.15484f, 14.7917f, 1.87502f, 14.5118f, 1.87502f, 14.1667f)
                curveTo(1.87502f, 13.8215f, 2.15484f, 13.5417f, 2.50002f, 13.5417f)
                horizontalLineTo(5.20835f)
                verticalLineTo(10.8333f)
                curveTo(5.20835f, 10.4882f, 5.48818f, 10.2083f, 5.83335f, 10.2083f)
                close()
            }
        }.build()
        
        return _new!!
    }

private var _new: ImageVector? = null

