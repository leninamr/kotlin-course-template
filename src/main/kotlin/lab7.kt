import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass

import java.io.File

object SerializeShapes {
    private val json = Json {
        prettyPrint = true
        serializersModule = SerializersModule {
            polymorphic(Shape::class) {
                subclass(Circle::class)
                subclass(Square::class)
                subclass(Rectangle::class)
                subclass(Triangle::class)
            }
        }
    }

    fun encode(inList: List<Shape>): String {
        return json.encodeToString(inList)
    }

    fun decode(inString: String): List<Shape> {
        return json.decodeFromString(inString)
    }
}

object FileIO {
    fun write(path: String, input: String) {
        return File(path).writeText(input)
    }

    fun read(path: String): String {
        return File(path).readText()
    }
}