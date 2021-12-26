import org.testng.annotations.Test

import org.testng.Assert.*

//коммиты по исправлениям загружены от одного человека, но решения по исправлениям принимались коллективно с демонстрацией в дискорде :)

class MatrixTest {
    private val matrixA = Matrix(
        arrayOf(
            arrayOf(1.0, 2.0),
            arrayOf(3.0, 4.0)
        )
    )

    private val matrixB = Matrix(
        arrayOf(
            arrayOf(9.0, 8.0),
            arrayOf(7.0, 6.0)
        )
    )

    private val matrixOfZeroes = Matrix(
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

    @Test
    fun testGetNumberOfRows() {
        val testMatrix = Matrix(
            arrayOf(
                arrayOf(23.0, 20.0, 1.0),
                arrayOf(55.0, 48.0, 3.0)
            )
        )
        assertEquals((testMatrix.numberOfRows), 2)
    }

    @Test
    fun testGetNumberOfColumns() {
        val testMatrix = Matrix(
            arrayOf(
                arrayOf(23.0, 20.0, 1.0),
                arrayOf(55.0, 48.0, 3.0)
            )
        )
        assertEquals((testMatrix.numberOfColumns), 3)
    }

    @Test
    fun testGet() {
        val testMatrix = Matrix(
            arrayOf(
                arrayOf(0.5, 1.0),
                arrayOf(1.5, 2.0)
            )
        )
        assertEquals(testMatrix[0, 0], 0.5)
    }

    @Test
    fun testSet() {
        val testMatrix = Matrix(
            arrayOf(
                arrayOf(0.5, 1.0),
                arrayOf(1.5, 2.0)
            )
        )
        testMatrix[1, 1] = 10.0
        assertEquals(testMatrix[1, 1], 10.0)
    }

    @Test
    fun testPlusAssign() {
        val result = Matrix(
            arrayOf(
                arrayOf(2.0, 4.0),
                arrayOf(6.0, 8.0)
            )
        )
        matrixA += matrixA
        assertEquals(matrixA, result)
    }

    @Test
    fun testMinusAssign() {
        matrixA -= matrixA
        assertEquals(matrixA, matrixOfZeroes)
    }

    @Test
    fun testTimesWithScalarAssign() {
        val result = Matrix(
            arrayOf(
                arrayOf(2.0, 4.0),
                arrayOf(6.0, 8.0)
            )
        )
        matrixA *= 2.0
        assertEquals(matrixA, result)
    }

    @Test
    fun testTimesWithMatrixAssign() {
        val result = Matrix(
            arrayOf(
                arrayOf(23.0, 20.0),
                arrayOf(55.0, 48.0)
            )
        )
        matrixA *= matrixB
        assertEquals(matrixA, result)
    }

    @Test
    fun testDivAssign() {
        val result = Matrix(
            arrayOf(
                arrayOf(0.5, 1.0),
                arrayOf(1.5, 2.0)
            )
        )
        matrixA /= 2.0
        assertEquals(matrixA, result)
    }

    @Test
    fun testEqualsTrue() {
        val testMatrix = Matrix(
            arrayOf(
                arrayOf(1.0, 2.0),
                arrayOf(3.0, 4.0)
            )
        )
        assertEquals((matrixA == testMatrix), true)
    }

    @Test
    fun testEqualsFalse() {
        assertEquals((matrixA == matrixB), false)
    }

}