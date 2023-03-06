package bcp.designpatterns.coreui.typography

/**   Project property of Bcp
 *   Created by Dazzord.
 */
import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import bcp.designpatterns.coreui.colors.white

val typography = Typography(
    body1 = TextStyle(
        fontFamily = fontMonserrat,
        fontWeight = FontWeight.Light,
        fontSize = 14.sp,
        color = white
    ),
    h1 = TextStyle(
        fontFamily = fontMonserrat,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        color = white
    ),
    button = TextStyle(
        fontFamily = fontMonserrat,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        color = white
    ),
    subtitle1 = TextStyle(
        fontFamily = fontMonserrat,
        fontWeight = FontWeight.Normal,
        fontSize = 13.sp,
        color = white
    ),
    h2 = TextStyle(
        fontFamily = fontMonserrat,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        color = white
    ),
    h3 = TextStyle(
        fontFamily = fontMonserrat,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        color = white
    ),
    h4 = TextStyle(
        fontFamily = fontMonserrat,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
        color = white
    ),
    h5 = TextStyle(
        fontFamily = fontMonserrat,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        color = white
    ),

    )