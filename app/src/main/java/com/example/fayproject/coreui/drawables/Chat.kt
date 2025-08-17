package com.example.fayproject.coreui.drawables

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val FayIcons.Chat: ImageVector
    get() {
        if (_chats != null) return _chats!!
        
        _chats = ImageVector.Builder(
            name = "chats",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                fill = SolidColor(Color(0xFFFFFFFF))
            ) {
                moveTo(2.73442f, 11.4706f)
                curveTo(2.73442f, 6.382f, 6.83849f, 2.25f, 11.9096f, 2.25f)
                curveTo(14.2372f, 2.25f, 16.3635f, 3.12197f, 17.9803f, 4.55667f)
                curveTo(18.7229f, 5.21566f, 19.3585f, 5.99369f, 19.8577f, 6.86126f)
                curveTo(20.0699f, 7.23006f, 20.2574f, 7.61507f, 20.4181f, 8.014f)
                curveTo(20.5728f, 8.39824f, 20.3867f, 8.83514f, 20.0025f, 8.98984f)
                curveTo(19.6182f, 9.14455f, 19.1813f, 8.95847f, 19.0266f, 8.57423f)
                curveTo(18.8922f, 8.24041f, 18.7352f, 7.91814f, 18.5576f, 7.60933f)
                curveTo(18.1395f, 6.88271f, 17.6069f, 6.23077f, 16.9847f, 5.67863f)
                curveTo(15.631f, 4.47744f, 13.8554f, 3.75f, 11.9096f, 3.75f)
                curveTo(7.67451f, 3.75f, 4.23442f, 7.20282f, 4.23442f, 11.4706f)
                curveTo(4.23442f, 12.6797f, 4.51022f, 13.8219f, 5.00117f, 14.8387f)
                curveTo(5.26521f, 15.3856f, 5.27048f, 16.0683f, 4.90688f, 16.6278f)
                lineTo(3.5459f, 18.7218f)
                curveTo(3.41938f, 18.9327f, 3.57477f, 19.1912f, 3.80484f, 19.1912f)
                horizontalLineTo(7.85722f)
                curveTo(8.27143f, 19.1912f, 8.60722f, 19.527f, 8.60722f, 19.9412f)
                curveTo(8.60722f, 20.3554f, 8.27143f, 20.6912f, 7.85722f, 20.6912f)
                horizontalLineTo(3.80484f)
                curveTo(2.38224f, 20.6912f, 1.52963f, 19.1239f, 2.27482f, 17.9252f)
                lineTo(2.27881f, 17.9188f)
                lineTo(3.64918f, 15.8103f)
                curveTo(3.69498f, 15.7399f, 3.71297f, 15.6206f, 3.65037f, 15.4909f)
                curveTo(3.06325f, 14.2749f, 2.73442f, 12.9102f, 2.73442f, 11.4706f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFFFFFFF)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(9.50953f, 15.7057f)
                curveTo(9.50953f, 12.3715f, 12.1991f, 9.66162f, 15.5253f, 9.66162f)
                curveTo(18.8515f, 9.66162f, 21.541f, 12.3715f, 21.541f, 15.7057f)
                curveTo(21.541f, 16.6373f, 21.3307f, 17.5218f, 20.9544f, 18.3118f)
                lineTo(21.7819f, 19.585f)
                lineTo(21.7859f, 19.5914f)
                curveTo(22.3667f, 20.5257f, 21.7031f, 21.7499f, 20.5907f, 21.7499f)
                horizontalLineTo(15.5253f)
                curveTo(12.1991f, 21.7499f, 9.50953f, 19.04f, 9.50953f, 15.7057f)
                close()
                moveTo(15.5253f, 11.1616f)
                curveTo(13.0351f, 11.1616f, 11.0095f, 13.1923f, 11.0095f, 15.7057f)
                curveTo(11.0095f, 18.2192f, 13.0351f, 20.2499f, 15.5253f, 20.2499f)
                horizontalLineTo(20.425f)
                lineTo(19.6661f, 19.0822f)
                curveTo(19.3793f, 18.6409f, 19.387f, 18.1086f, 19.5898f, 17.6886f)
                curveTo(19.8786f, 17.0904f, 20.041f, 16.4182f, 20.041f, 15.7057f)
                curveTo(20.041f, 13.1923f, 18.0154f, 11.1616f, 15.5253f, 11.1616f)
                close()
            }
        }.build()
        
        return _chats!!
    }

private var _chats: ImageVector? = null

