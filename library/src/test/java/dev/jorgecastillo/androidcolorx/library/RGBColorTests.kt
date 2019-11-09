package dev.jorgecastillo.androidcolorx.library

import android.os.Build
import androidx.test.ext.junit.runners.AndroidJUnit4
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@Config(sdk = [Build.VERSION_CODES.O_MR1])
@RunWith(AndroidJUnit4::class)
class RGBColorTests {

    @Test
    fun `is dark should return true for #e91e63`() {
        val color = RGBColor(233, 30, 99)

        assertTrue(color.isDark())
    }

    @Test
    fun `is dark should return false for #1ee9a4`() {
        val color = RGBColor(30, 233, 164)

        assertFalse(color.isDark())
    }

    @Test
    fun `lighten integer should enlighten the color`() {
        val color = RGBColor(233, 30, 99)

        assertEquals(RGBColor(242, 123, 163), color.lighten(20))
    }

    @Test
    fun `lighten float should enlighten the color`() {
        val color = RGBColor(233, 30, 99)

        assertEquals(RGBColor(242, 123, 163), color.lighten(0.2f))
    }

    @Test
    fun `darken integer should darken the color`() {
        val color = RGBColor(233, 30, 99)

        assertEquals(RGBColor(147, 14, 59), color.darken(20))
    }

    @Test
    fun `darken float should darken the color`() {
        val color = RGBColor(233, 30, 99)

        assertEquals(RGBColor(147, 14, 59), color.darken(0.2f))
    }

    @Test
    fun `darken integer should be equivalent to dark float`() {
        val color = RGBColor(233, 30, 99)

        assertEquals(color.darken(20), color.darken(0.2f))
    }

    @Test
    fun `shades should be properly calculated`() {
        val color = RGBColor(233, 30, 99)

        assertEquals(
            listOf(
                RGBColor(233, 30, 99),
                RGBColor(216, 21, 87),
                RGBColor(192, 19, 78),
                RGBColor(168, 16, 68),
                RGBColor(144, 14, 58),
                RGBColor(120, 12, 48),
                RGBColor(96, 9, 39),
                RGBColor(72, 7, 29),
                RGBColor(48, 5, 19),
                RGBColor(24, 2, 10),
                RGBColor(0, 0, 0)
            ),
            color.getShades()
        )
    }

    @Test
    fun `tints should be properly calculated`() {
        val color = RGBColor(233, 30, 99)

        assertEquals(
            listOf(
                RGBColor(233, 30, 99),
                RGBColor(235, 52, 115),
                RGBColor(237, 75, 130),
                RGBColor(240, 97, 146),
                RGBColor(242, 120, 161),
                RGBColor(244, 142, 177),
                RGBColor(246, 165, 193),
                RGBColor(248, 187, 208),
                RGBColor(251, 210, 224),
                RGBColor(253, 232, 239),
                RGBColor(255, 255, 255)
            ),
            color.getTints()
        )
    }

    @Test
    fun `complimentary colors should be calculated as expected`() {
        val color = RGBColor(233, 30, 99)

        assertEquals(RGBColor(30, 233, 164), color.complimentary())
    }

    @Test
    fun `triadic colors should be calculated as expected`() {
        val color = RGBColor(233, 30, 99)

        assertEquals(
            Pair(RGBColor(99, 233, 30), RGBColor(30, 99, 233)),
            color.triadic()
        )
    }

    @Test
    fun `tetradic colors should be calculated as expected`() {
        val color = RGBColor(233, 30, 99)

        assertEquals(
            Triple(RGBColor(201, 233, 30), RGBColor(30, 233, 164), RGBColor(62, 30, 233)),
            color.tetradic()
        )
    }

    @Test
    fun `analogous colors should be calculated as expected`() {
        val color = RGBColor(233, 30, 99)

        assertEquals(
            Pair(RGBColor(233, 62, 30), RGBColor(233, 30, 201)),
            color.analogous()
        )
    }
}