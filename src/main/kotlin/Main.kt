fun main() {
    /*
    //1st lab
    val str = "asd vb fasj fg hj bn mj"
    val str = "TestingWiiiithVeeeeryLOOOOngWord"
    print(alignText(str, 7, Alignment.LEFT))
    print("hell")
    // Try adding program arguments at Run/Debug configuration

    //3rd lab
    val ListOfShapes = listOf<Shape>(
        Circle(5.0),
        Square(10.0),
        Rectangle(2.0, 3.0),
        Triangle(3.0, 4.0, 5.0),
        /*Circle(30.0),
        Square(15.0),
        Rectangle(12.0,10.0),
        Triangle(5.0, 6.0, 7.0)
         */
    )
    var sumArea = 0.0
    var sumPerimeter = 0.0
    var maxArea: Shape = Square(0.0)
    var maxPerimeter: Shape = Square(0.0)
    for (shape in ListOfShapes) {
        sumArea += shape.calcArea()
        if (shape.calcArea() > maxArea.calcArea())
            maxArea = shape
        sumPerimeter += shape.calcPerimeter()
        if (shape.calcPerimeter() > maxPerimeter.calcPerimeter())
            maxPerimeter = shape
    }
    println("The sum of areas of all shapes is $sumArea")
    println("The sum of perimeters of all shapes is $sumPerimeter")
    println("The shape with largest area is ${maxArea::class.java.simpleName}")
    println("The shape with largest perimeter is ${maxPerimeter::class.java.simpleName}")
     */

    /*
    //4th lab
    val matrixA = Matrix(
        arrayOf(
            arrayOf(1.0, 2.0),
            arrayOf(3.0, 4.0)
        )
    )
    val matrixB = Matrix(
        arrayOf(
            arrayOf(10.0, 20.0),
            arrayOf(30.0, 40.0)
        )
    )
    println("Matrix A:\n" + matrixA.toString())
    println("Matrix B:\n" + matrixB.toString())
    println("A + B =\n" + (matrixA + matrixB).toString())
    println("A - B =\n" + (matrixA - matrixB).toString())
    println("A * B =\n" + (matrixA * matrixB).toString())
    println("-B =\n" + (-matrixB).toString())
    println("+B =\n" + (+matrixB).toString())
    println("5 * A =\n" + (matrixA * 5.0).toString())
    println("B / 10 =\n" + (matrixB / 10.0).toString())
    println("Is A = B?")
    println(matrixA == matrixB)
    matrixA += matrixB
    println("\nMatrix A+=B :\n" + matrixA.toString())

    */
    //lab 6
    val shapes = ShapeCollector<Shape>()
    shapes.add(Circle(5.0))
    shapes.addAll(listOf(
        Square(10.0),
        Rectangle(2.0, 3.0),
        Triangle(3.0, 4.0, 5.0),
        Circle(30.0),
        Square(15.0),
        Rectangle(12.0,10.0),
        Triangle(5.0, 6.0, 7.0)
    ))

    val result = shapes.getAll()
    println("All shapes:")
    for (shape in result) {
        println("${shape.javaClass} with perimeter = ${shape.calcPerimeter()}")
    }
}