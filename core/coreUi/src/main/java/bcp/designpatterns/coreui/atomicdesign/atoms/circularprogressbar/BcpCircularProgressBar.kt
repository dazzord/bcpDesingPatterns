package bcp.designpatterns.coreui.atomicdesign.atoms.circularprogressbar

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity

/**   Project property of BCP
 *   Created by Dazzord.
 */

@Composable
fun bcpCircularProgressBar(
    bcpCircularProgressBarParams: BcpCircularProgressBarParams
) {

    with(bcpCircularProgressBarParams) {
        val stroke = with(LocalDensity.current) {
            Stroke(width = stroke, cap = StrokeCap.Butt)
        }

        Canvas(modifier = Modifier.size(size)) {
            val diameterOffset = stroke.width / 2
            drawCircle(
                radius = size.minDimension / 2.0f - diameterOffset,
                color = backgroundColor, style = stroke
            )
        }
        CircularProgressIndicator(
            progress = progressValue,
            color = progressColor,
            modifier = Modifier.then(Modifier.size(size))
        )
    }
}