import org.testng.annotations.Test

import org.testng.Assert.*

class AlignedTextTests {

    @Test
    fun testWrongLength() {
        assertThrows { alignText("test", -5) }
    }

    @Test
    fun testAlignmentLeft() {
        assertEquals(
            alignText("one two three four five six", 8, Alignment.LEFT),
            "one two\nthree\nfour\nfive six\n"
        )
    }

    @Test
    fun testAlignmentWithLongWord() {
        assertEquals(
            alignText("TestingWiiiithVeeeeryLOOOOngWord", 7, Alignment.LEFT),
            "Testing\nWiiiith\nVeeeery\nLOOOOng\nWord\n"
        )
    }

    @Test
    fun testAlignmentRight() {
        assertEquals(
            alignText("one two three four five six", 8, Alignment.RIGHT),
            " one two\n   three\n    four\nfive six\n"
        )
    }

    @Test
    fun testAlignmentCenter() {
        assertEquals(
            alignText("one two three four five six", 7, Alignment.CENTER),
            "one two\n three \n four \n five \n  six  \n"
        )
    }
}