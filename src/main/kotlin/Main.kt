import java.time.Year

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

    val matrixC = Matrix(
        arrayOf(
            arrayOf(10.0, 20.0, 20.5),
            arrayOf(30.0, 40.0, 40.5)
        )
    )

    println("Matrix A:\n" + matrixA.toString())
    println("Matrix B:\n" + matrixB.toString())
    println("A * B =\n" + (matrixA * matrixB).toString())
    //matrixA *= matrixB
    //println(matrixA.toString())
    println("Matrix C:\n" + matrixC.toString())
    println("The dimensions (mxn) of matrix C is " + matrixC.numberOfRows +'x'+ matrixC.numberOfColumns + '\n')
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
    /*
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

    var result = shapes.getAll()
    println("All shapes:")
    for (shape in result) {
        println("${shape.javaClass} with perimeter = ${shape.calcPerimeter()}")
    }
    result = shapes.getAllSorted(ShapeComparators.perimeterAscending)
    println("\nAll shapes by perimeter ascending:")
    for (shape in result) {
        println("${shape.javaClass} with perimeter = ${shape.calcPerimeter()}")
    }
    result = shapes.getAllSorted(ShapeComparators.perimeterDescending)
    println("\nAll shapes by perimeter descending:")
    for (shape in result) {
        println("${shape.javaClass} with perimeter = ${shape.calcPerimeter()}")
    }
    result = shapes.getAllSorted(ShapeComparators.areaAscending)
    println("\nAll shapes by area ascending:")
    for (shape in result) {
        println("${shape.javaClass} with area = ${shape.calcArea()}")
    }
    result = shapes.getAllSorted(ShapeComparators.areaDescending)
    println("\nAll shapes by area descending:")
    for (shape in result) {
        println("${shape.javaClass} with area = ${shape.calcArea()}")
    }

    
    val circles = ShapeCollector<Circle>()
    circles.add(Circle(1.0))
    circles.add(Circle(2.0))
    result = circles.getAllSorted(ShapeComparators.radiusAscending)
    println("\nAll shapes by area ascending:")
    for (circle in result) {
        println("${circle.javaClass} with radius = ${circle.radius}")
    }
    result = circles.getAllSorted(ShapeComparators.radiusDescending)
    println("\nAll shapes by area descending:")
    for (circle in result) {
        println("${circle.javaClass} with radius = ${circle.radius}")
    }
    result = circles.getAllSorted(ShapeComparators.areaDescending)
    println("\nAll shapes by area descending:")
    for (circle in result) {
        println("${circle.javaClass} with radius = ${circle.calcArea()}")
    }

    println("\nAll squares")
    val squares = shapes.getAllByClass(Square::class.java)
    for (shape in squares) {
        println("${shape.javaClass} with perimeter = ${shape.calcPerimeter()}")
    }
    */
    
    /*
    //lab 7
    val pathIn = "C:/Users/Marina/IdeaProjects/kotlin-course-template/src/main/kotlin/input.json"
    val pathOut = "C:/Users/Marina/IdeaProjects/kotlin-course-template/src/main/kotlin/output.json"

    val matrixA = Matrix(
        arrayOf(
            arrayOf(1.0, 2.0),
            arrayOf(3.0, 4.0)
        )
    )
    println(SerializeShapes.encode(matrixA))
    FileIO.write(pathOut, SerializeShapes.encode(matrixA))
    println(SerializeShapes.decode(FileIO.read(pathIn)))




 */
/*val listOfShapes: MutableList<Shape> = SerializeShapes.decode(FileIO.read(pathIn))
    println(SerializeShapes.encode(listOfShapes))
    listOfShapes.add(Square(10.0))
    listOfShapes.add(Triangle(3.0, 4.0, 5.0))
    FileIO.write(pathOut, SerializeShapes.encode(listOfShapes))
    */
    //lab 5
    val library = LibraryServiceImplement()
    val book1 = Book("Dandelion wine",Author("Ray","","Bradbury"),Genre.ScienceFiction,Year.of(1964))

    val book2 = Book("Master and Margarita",Author("Mikhail","Afanasievich","Bulgakov"),Genre.Novel,Year.of(1954))
    library.addBook(book1,Status.Available)
    library.addBook(book2,Status.Restoration)

    library.registerUser("David","Robert","Jones")
    library.registerUser("Ivan","Pavlovich","Lenin")
    println("\nAll statuses: ")
    library.getAllBookStatuses().forEach { println("${it.key.name} is ${it.value}") }

    println("\n" + library.findBooks( genre = Genre.ScienceFiction))
    println("\nAvailable now:\n" + library.getAllAvailableBooks())

}
