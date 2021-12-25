import org.testng.annotations.Test

import org.testng.Assert.*

class MatrixTest {
    private var matrixA = Matrix(
        arrayOf(
            arrayOf(1.0, 2.0),
            arrayOf(3.0, 4.0)
        )
    )

    private var matrixB = Matrix(
        arrayOf(
            arrayOf(9.0, 8.0),
            arrayOf(7.0, 6.0)
        )
    )

    private var matrixOfZeroes = Matrix(
        arrayOf(
            arrayOf(0.0, 0.0),
            arrayOf(0.0, 0.0)
        )
    )

    @Test
    fun testInitEmptyMatrix() {
        assertThrows { Matrix(arrayOf(emptyArray())) }
    }

    @Test
    fun testPlusZeroes() {
        assertEquals((matrixA + matrixOfZeroes), matrixA)
    }

    @Test
    fun testPlus() {
        val result = Matrix(
            arrayOf(
                arrayOf(10.0, 10.0),
                arrayOf(10.0, 10.0)
            )
        )
        assertEquals((matrixA + matrixB), result)
    }

    @Test
    fun testMinus() {
        val result = Matrix(
            arrayOf(
                arrayOf(-8.0, -6.0),
                arrayOf(-4.0, -2.0)
            )
        )
        assertEquals((matrixA - matrixB), result)
    }

    @Test
    fun testTimesWithScalar() {
        val result = Matrix(
            arrayOf(
                arrayOf(2.0, 4.0),
                arrayOf(6.0, 8.0)
            )
        )
        assertEquals((matrixA * 2.0), result)
    }

    @Test
    fun testTimesWithMatrix() {
        val result = Matrix(
            arrayOf(
                arrayOf(23.0, 20.0),
                arrayOf(55.0, 48.0)
            )
        )
        assertEquals((matrixA * matrixB), result)
    }

    @Test
    fun testUnaryMinus() {
        val result = Matrix(
            arrayOf(
                arrayOf(-1.0, -2.0),
                arrayOf(-3.0, -4.0)
            )
        )
        assertEquals((-matrixA), result)
    }

    @Test
    fun testDiv() {
        val result = Matrix(
            arrayOf(
                arrayOf(0.5, 1.0),
                arrayOf(1.5, 2.0)
            )
        )
        assertEquals((matrixA / 2.0), result)
    }

    @Test
    fun testTestToString() {
        val result = "1.0 2.0 \n3.0 4.0 \n"
        assertEquals((matrixA.toString()), result)
    }
}