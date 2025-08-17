package com.example.fayproject.coreui.drawables

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val FayIcons.Journal: ImageVector
    get() {
        if (_notebookText != null) return _notebookText!!
        
        _notebookText = ImageVector.Builder(
            name = "notebookText",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                fill = SolidColor(Color(0xFFFFFFFF))
            ) {
                moveTo(6.25f, 9.5f)
                curveTo(6.25f, 9.08579f, 6.58579f, 8.75f, 7f, 8.75f)
                horizontalLineTo(11f)
                curveTo(11.4142f, 8.75f, 11.75f, 9.08579f, 11.75f, 9.5f)
                curveTo(11.75f, 9.91421f, 11.4142f, 10.25f, 11f, 10.25f)
                horizontalLineTo(7f)
                curveTo(6.58579f, 10.25f, 6.25f, 9.91421f, 6.25f, 9.5f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFFFFFFF))
            ) {
                moveTo(6.25f, 13f)
                curveTo(6.25f, 12.5858f, 6.58579f, 12.25f, 7f, 12.25f)
                horizontalLineTo(15f)
                curveTo(15.4142f, 12.25f, 15.75f, 12.5858f, 15.75f, 13f)
                curveTo(15.75f, 13.4142f, 15.4142f, 13.75f, 15f, 13.75f)
                horizontalLineTo(7f)
                curveTo(6.58579f, 13.75f, 6.25f, 13.4142f, 6.25f, 13f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFFFFFFF))
            ) {
                moveTo(6.25f, 16.5f)
                curveTo(6.25f, 16.0858f, 6.58579f, 15.75f, 7f, 15.75f)
                horizontalLineTo(11f)
                curveTo(11.4142f, 15.75f, 11.75f, 16.0858f, 11.75f, 16.5f)
                curveTo(11.75f, 16.9142f, 11.4142f, 17.25f, 11f, 17.25f)
                horizontalLineTo(7f)
                curveTo(6.58579f, 17.25f, 6.25f, 16.9142f, 6.25f, 16.5f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFFFFFFF)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(7.5f, 1.25f)
                curveTo(7.91421f, 1.25f, 8.25f, 1.58579f, 8.25f, 2f)
                verticalLineTo(2.78543f)
                curveTo(9.07589f, 2.75018f, 10.0587f, 2.75f, 11.25f, 2.75f)
                verticalLineTo(2f)
                curveTo(11.25f, 1.58579f, 11.5858f, 1.25f, 12f, 1.25f)
                curveTo(12.4142f, 1.25f, 12.75f, 1.58579f, 12.75f, 2f)
                verticalLineTo(2.75f)
                curveTo(13.9413f, 2.75f, 14.9241f, 2.75018f, 15.75f, 2.78543f)
                verticalLineTo(2f)
                curveTo(15.75f, 1.58579f, 16.0858f, 1.25f, 16.5f, 1.25f)
                curveTo(16.9142f, 1.25f, 17.25f, 1.58579f, 17.25f, 2f)
                verticalLineTo(2.9186f)
                curveTo(17.8296f, 3.0081f, 18.344f, 3.14784f, 18.826f, 3.37003f)
                curveTo(20.2855f, 4.0429f, 21.4571f, 5.21448f, 22.13f, 6.67405f)
                curveTo(22.4587f, 7.38707f, 22.6069f, 8.17106f, 22.679f, 9.13215f)
                curveTo(22.75f, 10.0791f, 22.75f, 11.2564f, 22.75f, 12.769f)
                verticalLineTo(12.831f)
                curveTo(22.75f, 14.3436f, 22.75f, 15.5209f, 22.679f, 16.4678f)
                curveTo(22.6069f, 17.4289f, 22.4587f, 18.2129f, 22.13f, 18.926f)
                curveTo(21.4571f, 20.3855f, 20.2855f, 21.5571f, 18.826f, 22.23f)
                curveTo(18.1129f, 22.5587f, 17.3289f, 22.7069f, 16.3678f, 22.779f)
                curveTo(15.4209f, 22.85f, 14.2436f, 22.85f, 12.731f, 22.85f)
                horizontalLineTo(11.269f)
                curveTo(9.75643f, 22.85f, 8.57909f, 22.85f, 7.63215f, 22.779f)
                curveTo(6.67106f, 22.7069f, 5.88707f, 22.5587f, 5.17405f, 22.23f)
                curveTo(3.71448f, 21.5571f, 2.5429f, 20.3855f, 1.87003f, 18.926f)
                curveTo(1.54132f, 18.2129f, 1.39305f, 17.4289f, 1.32099f, 16.4678f)
                curveTo(1.24999f, 15.5209f, 1.25f, 14.3436f, 1.25f, 12.831f)
                verticalLineTo(12.769f)
                curveTo(1.25f, 11.2564f, 1.24999f, 10.0791f, 1.32099f, 9.13215f)
                curveTo(1.39305f, 8.17106f, 1.54132f, 7.38707f, 1.87003f, 6.67405f)
                curveTo(2.5429f, 5.21448f, 3.71448f, 4.0429f, 5.17405f, 3.37003f)
                curveTo(5.65601f, 3.14784f, 6.1704f, 3.0081f, 6.75f, 2.9186f)
                verticalLineTo(2f)
                curveTo(6.75f, 1.58579f, 7.08579f, 1.25f, 7.5f, 1.25f)
                close()
                moveTo(6.75f, 4.44048f)
                curveTo(6.37882f, 4.51145f, 6.07439f, 4.60669f, 5.80204f, 4.73225f)
                curveTo(4.66682f, 5.25559f, 3.75559f, 6.16682f, 3.23225f, 7.30204f)
                curveTo(3.00982f, 7.78453f, 2.88252f, 8.36771f, 2.81679f, 9.24431f)
                curveTo(2.75049f, 10.1286f, 2.75f, 11.2499f, 2.75f, 12.8f)
                curveTo(2.75f, 14.3501f, 2.75049f, 15.4714f, 2.81679f, 16.3557f)
                curveTo(2.88252f, 17.2323f, 3.00982f, 17.8155f, 3.23225f, 18.298f)
                curveTo(3.75559f, 19.4332f, 4.66682f, 20.3444f, 5.80204f, 20.8678f)
                curveTo(6.28453f, 21.0902f, 6.86771f, 21.2175f, 7.74431f, 21.2832f)
                curveTo(8.62861f, 21.3495f, 9.74987f, 21.35f, 11.3f, 21.35f)
                horizontalLineTo(12.7f)
                curveTo(14.2501f, 21.35f, 15.3714f, 21.3495f, 16.2557f, 21.2832f)
                curveTo(17.1323f, 21.2175f, 17.7155f, 21.0902f, 18.198f, 20.8678f)
                curveTo(19.3332f, 20.3444f, 20.2444f, 19.4332f, 20.7678f, 18.298f)
                curveTo(20.9902f, 17.8155f, 21.1175f, 17.2323f, 21.1832f, 16.3557f)
                curveTo(21.2495f, 15.4714f, 21.25f, 14.3501f, 21.25f, 12.8f)
                curveTo(21.25f, 11.2499f, 21.2495f, 10.1286f, 21.1832f, 9.24431f)
                curveTo(21.1175f, 8.36771f, 20.9902f, 7.78453f, 20.7678f, 7.30204f)
                curveTo(20.2444f, 6.16682f, 19.3332f, 5.25559f, 18.198f, 4.73225f)
                curveTo(17.9256f, 4.60669f, 17.6212f, 4.51145f, 17.25f, 4.44048f)
                verticalLineTo(5f)
                curveTo(17.25f, 5.41421f, 16.9142f, 5.75f, 16.5f, 5.75f)
                curveTo(16.0858f, 5.75f, 15.75f, 5.41421f, 15.75f, 5f)
                verticalLineTo(4.28682f)
                curveTo(14.9611f, 4.25081f, 13.9948f, 4.25002f, 12.75f, 4.25f)
                verticalLineTo(5f)
                curveTo(12.75f, 5.41421f, 12.4142f, 5.75f, 12f, 5.75f)
                curveTo(11.5858f, 5.75f, 11.25f, 5.41421f, 11.25f, 5f)
                verticalLineTo(4.25f)
                curveTo(10.0052f, 4.25002f, 9.03892f, 4.25081f, 8.25f, 4.28682f)
                verticalLineTo(5f)
                curveTo(8.25f, 5.41421f, 7.91421f, 5.75f, 7.5f, 5.75f)
                curveTo(7.08579f, 5.75f, 6.75f, 5.41421f, 6.75f, 5f)
                verticalLineTo(4.44048f)
                close()
            }
        }.build()
        
        return _notebookText!!
    }

private var _notebookText: ImageVector? = null

