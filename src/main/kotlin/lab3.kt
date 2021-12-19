import kotlin.math.PI
import kotlin.math.sqrt
import kotlin.random.Random

interface Shape {
    fun calcArea(): Double
    fun calcPerimeter(): Double
}

class Circle(val Radius: Double) : Shape {
    init {
        if (Radius < 0) {
            throw IllegalArgumentException("Incorrect size of the radius")
        }
    }

    override fun calcArea(): Double {
        return PI * Radius * Radius
    }

    override fun calcPerimeter(): Double {
        return 2 * PI * Radius
    }
}

class Square(val Side: Double) : Shape {
    init {
        if (Side < 0) {
            throw IllegalArgumentException("Incorrect side size of the square")
        }
    }

    override fun calcArea(): Double {
        return Side * Side
    }

    override fun calcPerimeter(): Double {
        return 4 * Side
    }
}

class Rectangle(val Side_a: Double, val Side_b: Double) : Shape {
    init {
        if ((Side_a < 0) or (Side_b < 0)) {
            throw IllegalArgumentException("Incorrect side size of the rectangle")
        }
    }

    override fun calcArea(): Double {
        return Side_a * Side_b
    }

    override fun calcPerimeter(): Double {
        return 2 * Side_a + 2 * Side_b
    }
}

class Triangle(val Side_a: Double, val Side_b: Double, val Side_c: Double) : Shape {
    init {
        if ((Side_a + Side_b < Side_c) or (Side_a + Side_c < Side_b) or (Side_b + Side_c < Side_a))
            throw IllegalArgumentException("This triangle can't exist")
        if ((Side_a < 0) or (Side_b < 0) or (Side_c < 0)) {
            throw IllegalArgumentException("Incorrect side size of the triangle")
        }
    }

    override fun calcArea(): Double {
        val p = calcPerimeter() / 2
        return sqrt(p * (p - Side_a) * (p - Side_b) * (p - Side_c))
    }

    override fun calcPerimeter(): Double {
        return Side_a + Side_b + Side_c
    }
}

interface ShapeFactory {
    fun createCircle(Radius: Double): Circle
    fun createSquare(Side: Double): Square
    fun createRectangle(Side_a: Double, Side_b: Double): Rectangle
    fun createTriangle(Side_a: Double, Side_b: Double, Side_c: Double): Triangle

    fun createRandomCircle(): Circle
    fun createRandomSquare(): Square
    fun createRandomRectangle(): Rectangle
    fun createRandomTriangle(): Triangle

    fun createRandomShape(): Shape
}

class ShapeFactoryImpl : ShapeFactory {
    override fun createCircle(Radius: Double): Circle {
        return Circle(Radius)
    }

    override fun createSquare(Side: Double): Square {
        return Square(Side)
    }

    override fun createRectangle(Side_a: Double, Side_b: Double): Rectangle {
        return Rectangle(Side_a, Side_b)
    }

    override fun createTriangle(Side_a: Double, Side_b: Double, Side_c: Double): Triangle {
        return Triangle(Side_a, Side_b, Side_c)
    }

    override fun createRandomCircle(): Circle {
        return Circle(Random.nextDouble(0.0, Double.MAX_VALUE))
    }

    override fun createRandomSquare(): Square {
        return Square(Random.nextDouble(0.0, Double.MAX_VALUE))
    }

    override fun createRandomRectangle(): Rectangle {
        return Rectangle(Random.nextDouble(0.0, Double.MAX_VALUE), Random.nextDouble(0.0, Double.MAX_VALUE))
    }

    override fun createRandomTriangle(): Triangle {
        return Triangle(
            Random.nextDouble(0.0, Double.MAX_VALUE),
            Random.nextDouble(0.0, Double.MAX_VALUE),
            Random.nextDouble(0.0, Double.MAX_VALUE)
        )
    }

    override fun createRandomShape(): Shape {
        return when (Random.nextInt(1, 5)) {
            1 -> createRandomCircle()
            2 -> createRandomSquare()
            3 -> createRandomRectangle()
            else -> createRandomTriangle()
        }
    }
}