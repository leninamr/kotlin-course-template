import org.testng.annotations.Test

import org.testng.Assert.*

class SerializeShapesTest {

    @Test
    fun testEncode1() {
        val list = listOf<Shape>(Square(2.0))
        val result = "[\n" +
                "    {\n" +
                "        \"type\": \"Square\",\n" +
                "        \"side\": 2.0\n" +
                "    }\n" +
                "]"
        assertEquals(SerializeShapes.encode(list), result)
    }

    @Test
    fun testEncode2() {
        val list = listOf(Square(2.0), Rectangle(2.0, 3.0))
        val result = "[\n" +
                "    {\n" +
                "        \"type\": \"Square\",\n" +
                "        \"side\": 2.0\n" +
                "    },\n" +
                "    {\n" +
                "        \"type\": \"Rectangle\",\n" +
                "        \"sideA\": 2.0,\n" +
                "        \"sideB\": 3.0\n" +
                "    }\n" +
                "]"
        assertEquals(SerializeShapes.encode(list), result)

    }

    @Test
    fun testDecode1() {
        val jsonString = "[\n" +
                "    {\n" +
                "        \"type\": \"Circle\",\n" +
                "        \"radius\": 2.0\n" +
                "    }\n" +
                "]"
        val result = mutableListOf(Circle(2.0))
        assertEquals(SerializeShapes.decode(jsonString)[0]::class.java.simpleName, result[0]::class.java.simpleName)
        assertEquals(SerializeShapes.decode(jsonString)[0].calcArea(), result[0].calcArea())
    }


    @Test
    fun testDecode2() {
        val jsonString = "[\n" +
                "    {\n" +
                "        \"type\": \"Square\",\n" +
                "        \"side\": 2.0\n" +
                "    },\n" +
                "    {\n" +
                "        \"type\": \"Rectangle\",\n" +
                "        \"sideA\": 2.0,\n" +
                "        \"sideB\": 3.0\n" +
                "    }\n" +
                "]"
        val result = mutableListOf(Square(2.0), Rectangle(2.0, 3.0))
        assertEquals(SerializeShapes.decode(jsonString)[0]::class.java.simpleName, result[0]::class.java.simpleName)
        assertEquals(SerializeShapes.decode(jsonString)[0].calcArea(), result[0].calcArea())
        assertEquals(SerializeShapes.decode(jsonString)[1]::class.java.simpleName, result[1]::class.java.simpleName)
        assertEquals(SerializeShapes.decode(jsonString)[1].calcArea(), result[1].calcArea())

    }
}