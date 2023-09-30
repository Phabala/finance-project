import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.platform.Typeface
import moe.tlaster.precompose.PreComposeApplication
import org.jetbrains.skia.FontStyle
import org.jetbrains.skia.Typeface
import platform.Foundation.NSNumber
import platform.Foundation.NSNumberFormatter
import platform.Foundation.NSURL
import platform.UIKit.UIApplication


actual fun getPlatformName(): String = "iOS"
fun MainViewController() = PreComposeApplication { App() }

private fun loadCustomFont(name: String): Typeface {
    return Typeface.makeFromName(name, FontStyle.NORMAL)
}

actual val icehimchanFontFamily: FontFamily = FontFamily(
    Typeface(loadCustomFont("icehimchan"))
)
actual val icejaramFontFamily: FontFamily = FontFamily(
    Typeface(loadCustomFont("icejaram"))
)
actual val icesiminFontFamily: FontFamily = FontFamily(
    Typeface(loadCustomFont("icesimin"))
)
actual val icesotongFontFamily: FontFamily = FontFamily(
    Typeface(loadCustomFont("icesotong"))
)
actual val pretendardFontFamily: FontFamily = FontFamily(
    Typeface(loadCustomFont("pretendard"))
)

actual fun formatDouble(value: Double, decimalPlaces: Int): String {
    val formatter = NSNumberFormatter()
    formatter.minimumFractionDigits = 0u
    formatter.maximumFractionDigits = decimalPlaces.toULong()
    formatter.numberStyle = 1u //Decimal
    return formatter.stringFromNumber(NSNumber(value))!!
}

actual fun openUrl(url: String?) {
    val nsUrl = url?.let { NSURL.URLWithString(it) } ?: return
    UIApplication.sharedApplication.openURL(nsUrl)
}