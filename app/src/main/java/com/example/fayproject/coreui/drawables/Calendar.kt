package com.example.fayproject.coreui.drawables

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val FayIcons.Calendar: ImageVector
    get() {
        if (_calendar != null) return _calendar!!
        
        _calendar = ImageVector.Builder(
            name = "calendar",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                fill = SolidColor(Color(0xFFFFFFFF)),
            ) {
                moveTo(8f, 8.75f)
                curveTo(7.58579f, 8.75f, 7.25f, 9.08579f, 7.25f, 9.5f)
                curveTo(7.25f, 9.91421f, 7.58579f, 10.25f, 8f, 10.25f)
                horizontalLineTo(16f)
                curveTo(16.4142f, 10.25f, 16.75f, 9.91421f, 16.75f, 9.5f)
                curveTo(16.75f, 9.08579f, 16.4142f, 8.75f, 16f, 8.75f)
                horizontalLineTo(8f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFFFFFFF)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(8.75f, 2f)
                curveTo(8.75f, 1.58579f, 8.41421f, 1.25f, 8f, 1.25f)
                curveTo(7.58579f, 1.25f, 7.25f, 1.58579f, 7.25f, 2f)
                verticalLineTo(3.36076f)
                curveTo(6.54739f, 3.44406f, 5.944f, 3.59421f, 5.38955f, 3.87671f)
                curveTo(4.30762f, 4.42798f, 3.42798f, 5.30762f, 2.87671f, 6.38955f)
                curveTo(2.54138f, 7.04768f, 2.39252f, 7.77479f, 2.32061f, 8.65494f)
                curveTo(2.24999f, 9.51929f, 2.25f, 10.5947f, 2.25f, 11.9664f)
                verticalLineTo(14.0336f)
                curveTo(2.25f, 15.4053f, 2.24999f, 16.4807f, 2.32061f, 17.3451f)
                curveTo(2.39252f, 18.2252f, 2.54138f, 18.9523f, 2.87671f, 19.6104f)
                curveTo(3.42798f, 20.6924f, 4.30762f, 21.572f, 5.38955f, 22.1233f)
                curveTo(6.04768f, 22.4586f, 6.77479f, 22.6075f, 7.65494f, 22.6794f)
                curveTo(8.51927f, 22.75f, 9.59469f, 22.75f, 10.9664f, 22.75f)
                horizontalLineTo(13.0336f)
                curveTo(14.4053f, 22.75f, 15.4807f, 22.75f, 16.3451f, 22.6794f)
                curveTo(17.2252f, 22.6075f, 17.9523f, 22.4586f, 18.6104f, 22.1233f)
                curveTo(19.6924f, 21.572f, 20.572f, 20.6924f, 21.1233f, 19.6104f)
                curveTo(21.4586f, 18.9523f, 21.6075f, 18.2252f, 21.6794f, 17.3451f)
                curveTo(21.75f, 16.4807f, 21.75f, 15.4053f, 21.75f, 14.0336f)
                verticalLineTo(11.9664f)
                curveTo(21.75f, 10.5947f, 21.75f, 9.51927f, 21.6794f, 8.65494f)
                curveTo(21.6075f, 7.77479f, 21.4586f, 7.04768f, 21.1233f, 6.38955f)
                curveTo(20.572f, 5.30762f, 19.6924f, 4.42798f, 18.6104f, 3.87671f)
                curveTo(18.056f, 3.59421f, 17.4526f, 3.44406f, 16.75f, 3.36076f)
                verticalLineTo(2f)
                curveTo(16.75f, 1.58579f, 16.4142f, 1.25f, 16f, 1.25f)
                curveTo(15.5858f, 1.25f, 15.25f, 1.58579f, 15.25f, 2f)
                verticalLineTo(3.26647f)
                curveTo(14.6102f, 3.24999f, 13.878f, 3.25f, 13.0336f, 3.25f)
                horizontalLineTo(10.9664f)
                curveTo(10.122f, 3.25f, 9.38977f, 3.24999f, 8.75f, 3.26647f)
                verticalLineTo(2f)
                close()
                moveTo(6.07054f, 5.21322f)
                curveTo(6.48197f, 5.00359f, 6.9897f, 4.87996f, 7.77708f, 4.81563f)
                curveTo(8.57322f, 4.75058f, 9.58749f, 4.75f, 11f, 4.75f)
                horizontalLineTo(13f)
                curveTo(14.4125f, 4.75f, 15.4268f, 4.75058f, 16.2229f, 4.81563f)
                curveTo(17.0103f, 4.87996f, 17.518f, 5.00359f, 17.9295f, 5.21322f)
                curveTo(18.7291f, 5.62068f, 19.3793f, 6.27085f, 19.7868f, 7.07054f)
                curveTo(19.9964f, 7.48197f, 20.12f, 7.9897f, 20.1844f, 8.77708f)
                curveTo(20.2494f, 9.57322f, 20.25f, 10.5875f, 20.25f, 12f)
                verticalLineTo(14f)
                curveTo(20.25f, 15.4125f, 20.2494f, 16.4268f, 20.1844f, 17.2229f)
                curveTo(20.12f, 18.0103f, 19.9964f, 18.518f, 19.7868f, 18.9295f)
                curveTo(19.3793f, 19.7291f, 18.7291f, 20.3793f, 17.9295f, 20.7868f)
                curveTo(17.518f, 20.9964f, 17.0103f, 21.12f, 16.2229f, 21.1844f)
                curveTo(15.4268f, 21.2494f, 14.4125f, 21.25f, 13f, 21.25f)
                horizontalLineTo(11f)
                curveTo(9.58749f, 21.25f, 8.57322f, 21.2494f, 7.77708f, 21.1844f)
                curveTo(6.9897f, 21.12f, 6.48197f, 20.9964f, 6.07054f, 20.7868f)
                curveTo(5.27085f, 20.3793f, 4.62068f, 19.7291f, 4.21322f, 18.9295f)
                curveTo(4.00359f, 18.518f, 3.87996f, 18.0103f, 3.81563f, 17.2229f)
                curveTo(3.75058f, 16.4268f, 3.75f, 15.4125f, 3.75f, 14f)
                verticalLineTo(12f)
                curveTo(3.75f, 10.5875f, 3.75058f, 9.57322f, 3.81563f, 8.77708f)
                curveTo(3.87996f, 7.9897f, 4.00359f, 7.48197f, 4.21322f, 7.07054f)
                curveTo(4.62068f, 6.27085f, 5.27085f, 5.62068f, 6.07054f, 5.21322f)
                close()
            }
        }.build()
        
        return _calendar!!
    }

private var _calendar: ImageVector? = null

