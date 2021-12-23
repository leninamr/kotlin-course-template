import kotlin.math.PI
import kotlin.math.sqrt
import kotlin.random.Random

interface Shape {
    fun calcArea(): Double
    fun calcPerimeter(): Double
}

class Circle(val radius: Double) : Shape {
    init {
        if (radius < 0) {
            throw IllegalArgumentException("Incorrect size of the radius")
        }
    }

    override fun calcArea(): Double {
        return PI * radius * radius
    }

    override fun calcPerimeter(): Double {
        return 2 * PI * radius
    }
}

class Square(val side: Double) : Shape {
    init {
        if (side < 0) {
            throw IllegalArgumentException("Incorrect side size of the square")
        }
    }

    override fun calcArea(): Double {
        return side * side
    }

    override fun calcPerimeter(): Double {
        return 4 * side
    }
}

class Rectangle(val sideA: Double, val sideB: Double) : Shape {
    init {
        if ((sideA < 0) or (sideB < 0)) {
            throw IllegalArgumentException("Incorrect side size of the rectangle")
        }
    }

    override fun calcArea(): Double {
        return sideA * sideB
    }

    override fun calcPerimeter(): Double {
        return 2 * sideA + 2 * sideB
    }
}

class Triangle(val sideA: Double, val sideB: Double, val sideC: Double) : Shape {
    init {
        if ((sideA + sideB < sideC) or (sideA + sideC < sideB) or (sideB + sideC < sideA))
            throw IllegalArgumentException("This triangle can't exist")
        if ((sideA < 0) or (sideB < 0) or (sideC < 0)) {
            throw IllegalArgumentException("Incorrect side size of the triangle")
        }
    }

    override fun calcArea(): Double {
        val p = calcPerimeter() / 2
        return sqrt(p * (p - sideA) * (p - sideB) * (p - sideC))
    }

    override fun calcPerimeter(): Double {
        return sideA + sideB + sideC
    }
}

interface ShapeFactory {
    fun createCircle(radius: Double): Circle
    fun createSquare(side: Double): Square
    fun createRectangle(sideA: Double, sideB: Double): Rectangle
    fun createTriangle(sideA: Double, sideB: Double, sideC: Double): Triangle

    fun createRandomCircle(): Circle
    fun createRandomSquare(): Square
    fun createRandomRectangle(): Rectangle
    fun createRandomTriangle(): Triangle

    fun createRandomShape(): Shape
}

class ShapeFactoryImpl : ShapeFactory {
    override fun createCircle(radius: Double): Circle {
        return Circle(radius)
    }

    override fun createSquare(side: Double): Square {
        return Square(side)
    }

    override fun createRectangle(sideA: Double, sideB: Double): Rectangle {
        return Rectangle(sideA, sideB)
    }

    override fun createTriangle(sideA: Double, sideB: Double, sideC: Double): Triangle {
        return Triangle(sideA, sideB, sideC)
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
        val sideA = Random.nextDouble(0.0, Double.MAX_VALUE)
        val sideB = Random.nextDouble(0.0, Double.MAX_VALUE)
        val sideC = Random.nextDouble(kotlin.math.max(sideA, sideB) - kotlin.math.min(sideA, sideB), sideA + sideB)
        return Triangle(sideA, sideB, sideC)
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