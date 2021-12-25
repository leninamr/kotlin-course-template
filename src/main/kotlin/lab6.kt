class ShapeCollector<T : Shape> {
    private val allShapes = mutableListOf<T>()

    fun add(new: T) { allShapes.add(new) }
    fun addAll(new: Collection<T>) { allShapes.addAll(new) }

    fun getAll(): List<T> = allShapes.toList()

    fun getAllSorted(comparator: Comparator<in T>): List<T> = allShapes.sortedWith(comparator)

    fun getAllByClass(shapeClass : Class<out T>) : List<T> = allShapes.filter { it.javaClass == shapeClass }.toList()
}

object ShapeComparators{
    val perimeterAscending = compareBy<Shape> { it.calcPerimeter() }
    val perimeterDescending = compareByDescending<Shape> { it.calcPerimeter() }
    val areaAscending = compareBy<Shape> { it.calcArea() }
    val areaDescending = compareByDescending<Shape> { it.calcArea() }
    val radiusAscending = compareBy<Circle> { it.radius }
    val radiusDescending = compareByDescending<Circle> { it.radius }
}
