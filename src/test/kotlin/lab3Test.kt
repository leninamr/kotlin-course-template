import org.testng.annotations.Test
import kotlin.math.PI
import org.testng.Assert.*

class lab3Test {

    @Test
    fun testWrongValueCircle() {
        assertThrows { Circle(-5.0) }
    }

    @Test
    fun testWrongValueCreateCircle() {
        assertThrows { ShapeFactoryImpl().createCircle(-5.0) }
    }

    @Test
    fun testCalcAreaCircle() {
        assertEquals(Circle(10.0).calcArea(), PI * 10.0 * 10.0)
    }

    @Test
    fun testCalcPerimeterCircle() {
        assertEquals(Circle(10.0).calcPerimeter(), 2.0 * PI * 10.0)
    }

    @Test
    fun testWrongValueSquare() {
        assertThrows { Square(-5.0) }
    }

    @Test
    fun testWrongValueCreateSquare() {
        assertThrows { ShapeFactoryImpl().createSquare(-5.0) }
    }

    @Test
    fun testCalcAreaSquare() {
        assertEquals(Square(10.0).calcArea(), 10.0 * 10.0)
    }

    @Test
    fun testCalcPerimeterSquare() {
        assertEquals(Square(10.0).calcPerimeter(), 4.0 * 10.0)
    }


    @Test
    fun testWrongValueRectangle() {
        assertThrows { Rectangle(-5.0, 1.0) }
    }

    @Test
    fun testWrongValueCreateRectangle() {
        assertThrows { ShapeFactoryImpl().createRectangle(-5.0, 1.0) }
    }

    @Test
    fun testCalcAreaRectangle() {
        assertEquals(Rectangle(10.0, 5.0).calcArea(), 10.0 * 5.0)
    }

    @Test
    fun testCalcPerimeterRectangle() {
        assertEquals(Rectangle(10.0, 5.0).calcPerimeter(), 2.0 * 10.0 + 2.0 * 5.0)
    }


    @Test
    fun testWrongValueTriangle() {
        assertThrows { Triangle(-5.0, 1.0, -3.0) }
    }

    @Test
    fun testDidntExictedTriangle() {
        assertThrows { Triangle(1.0, 1.0, 10.0) }
    }

    @Test
    fun testWrongValueCreateTriangle() {
        assertThrows { ShapeFactoryImpl().createTriangle(-5.0, 1.0, -3.0) }
    }

    @Test
    fun testCalcAreaTriangle() {
        assertEquals(Triangle(5.0, 4.0, 3.0).calcArea(), 6.0)
    }

    @Test
    fun testCalcPerimeterTriangle() {
        assertEquals(Triangle(5.0, 4.0, 3.0).calcPerimeter(), 12.0)
    }

}