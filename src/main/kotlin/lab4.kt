class Matrix(
    initMatrix: Array<Array<Double>>
) {
    private var matrix: Array<Array<Double>> = emptyArray()

    init {
        if (initMatrix.isEmpty() or initMatrix[0].isEmpty()) throw IllegalArgumentException("The entered matrix is empty")
        val length = initMatrix[0].size
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

    fun getSizes(): Pair<Int, Int> {
        return Pair(matrix.size, matrix[0].size)
    }

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
    operator fun times(scalar: Double) {
        TODO("Not yet implemented")
    }

    operator fun timesAssign(scalar: Double) {
        TODO("Not yet implemented")
    }

    operator fun unaryMinus(): Matrix {
        TODO("Not yet implemented")
    }

    operator fun unaryPlus(): Matrix {
        return this
    }
    // ...
}
