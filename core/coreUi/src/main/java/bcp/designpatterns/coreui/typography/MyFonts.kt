package bcp.designpatterns.coreui.typography

/**   Project property of BCP
 *   Created by Dazzord.
 */

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import bcp.designpatterns.coreui.R


val fontMonserrat = FontFamily(
    Font(R.font.montserratbold, weight = FontWeight.Bold),
    Font(R.font.montserratlight, weight = FontWeight.Light),
    Font(R.font.montserratthin, weight = FontWeight.Thin),
    Font(R.font.montserratmedium, weight = FontWeight.Normal)
)
