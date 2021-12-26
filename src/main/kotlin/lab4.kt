class Matrix(
    initMatrix: Array<Array<Double>>
) {
    private var matrix: Array<Array<Double>> = emptyArray()

    val numberOfRows: Int
        get() = matrix.size
    val numberOfColumns: Int
        get() = matrix[0].size

    init {
        if (initMatrix.isEmpty() or initMatrix[0].isEmpty()) throw IllegalArgumentException("The entered matrix is empty")
        val length = initMatrix[0].size
        matrix = initMatrix.clone()
        for (i in initMatrix.indices) {
            if (initMatrix[i].size != length) throw IllegalArgumentException("The entered matrix has wrong size")
            matrix[i] = initMatrix[i].clone()
        }
    }

    operator fun get(i: Int, j: Int): Double {
        if ((i >= matrix.size) or (j >= matrix[0].size)) throw IllegalArgumentException("The entered index is out of bounds")
        return matrix[i][j]
    }

    operator fun set(i: Int, j: Int, value: Double) {
        if ((i >= matrix.size) or (j >= matrix[0].size)) throw IllegalArgumentException("The entered index out of bounds")
        matrix[i][j] = value
    }
/*
    fun getNumberOfRows(): Int {
        return matrix.size
    }
    fun getNumberOfColumns(): Int {
        return matrix[0].size
    }
 */
    operator fun plus(other: Matrix): Matrix {
        val result = Matrix(other.matrix)
        if ((other.matrix.size != matrix.size) or (other.matrix[0].size != matrix[0].size)) throw IllegalArgumentException(
            "The dimensions of matrices are not converge"
        )
        else {
            for (i in matrix.indices)
                for (j in matrix[i].indices)
                    result[i, j] = this[i, j] + other[i, j]
        }
        return result
    }

    operator fun plusAssign(other: Matrix) {
        if ((other.matrix.size != matrix.size) or (other.matrix[0].size != matrix[0].size)) throw IllegalArgumentException(
            "The dimensions of matrices are not converge"
        )
        else {
            for (i in matrix.indices)
                for (j in matrix[i].indices)
                    this[i, j] += other[i, j]
        }
    }

    operator fun minus(other: Matrix): Matrix {
        val result = Matrix(other.matrix)
        if ((other.matrix.size != matrix.size) or (other.matrix[0].size != matrix[0].size)) throw IllegalArgumentException(
            "The dimensions of matrices are not converge"
        )
        else {
            for (i in matrix.indices)
                for (j in matrix[i].indices)
                    result[i, j] = this[i, j] - other[i, j]
        }
        return result
    }

    operator fun minusAssign(other: Matrix) {
        if ((other.matrix.size != matrix.size) or (other.matrix[0].size != matrix[0].size)) throw IllegalArgumentException(
            "The dimensions of matrices are not converge"
        )
        else {
            for (i in matrix.indices)
                for (j in matrix[i].indices)
                    this[i, j] -= other[i, j]
        }
    }

    operator fun times(scalar: Double): Matrix {
        val result = Matrix(matrix)
        for (i in matrix.indices)
            for (j in matrix[i].indices)
                result[i, j] = scalar * this[i, j]
        return result
    }

    operator fun timesAssign(scalar: Double) {
        for (i in matrix.indices)
            for (j in matrix[i].indices)
                this[i, j] = scalar * this[i, j]
    }

    operator fun times(other: Matrix): Matrix {
        val result: Matrix
        if (other.matrix.size != matrix[0].size) throw IllegalArgumentException(
            "The dimensions of matrices are wrong"
        )
        else {
            result = Matrix(Array(matrix.size) { Array(other.matrix[0].size) { 0.0 } })
            for (i in matrix.indices)
                for (j in matrix[i].indices) {
                    for (k in matrix[i].indices) {
                        result[i, j] += this[i, k] * other[k, j]
                    }
                }
        }
        return result
    }

    operator fun unaryMinus(): Matrix {
        return this.times(-1.0)
    }

    operator fun unaryPlus(): Matrix {
        return this
    }

    operator fun timesAssign(other: Matrix) {
        this.matrix = this.times(other).matrix
    }

    operator fun div(scalar: Double): Matrix {
        val result = Matrix(matrix)
        for (i in matrix.indices)
            for (j in matrix[i].indices)
                result[i, j] = this[i, j] / scalar
        return result
    }

    operator fun divAssign(scalar: Double) {
        for (i in matrix.indices)
            for (j in matrix[i].indices)
                this[i, j] = this[i, j] / scalar
    }

    override fun toString(): String {
        var out = ""
        for (i in matrix.indices) {
            for (j in matrix[0].indices)
                out += matrix[i][j].toString() + " "
            out += "\n"
        }
        return out
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Matrix

        if (!matrix.contentDeepEquals(other.matrix)) return false

        return true
    }

    override fun hashCode(): Int {
        return matrix.contentDeepHashCode()
    }
}
