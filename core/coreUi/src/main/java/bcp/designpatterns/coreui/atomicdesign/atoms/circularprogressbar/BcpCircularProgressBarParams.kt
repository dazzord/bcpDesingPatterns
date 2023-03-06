package bcp.designpatterns.coreui.atomicdesign.atoms.circularprogressbar

import androidx.compose.material.ProgressIndicatorDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import bcp.designpatterns.coreui.colors.lightThinBlack
import bcp.designpatterns.coreui.colors.secondary

/**   Project property of BCP
 *   Created by Dazzord.
 */

data class BcpCircularProgressBarParams(
    var progressValue: Float = 0f,
    var size: Dp = 90.dp,
    var stroke: Float = ProgressIndicatorDefaults.StrokeWidth.value,
    var backgroundColor: Color = lightThinBlack,
    var progressColor: Color = secondary
)