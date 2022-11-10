package creational.factory.factory

sealed class Shape {
    class Circle(radius: Double) : Shape()
    class Square(length: Double) : Shape()
}

class ShapeName(
    name: String
)

/**
 * [Shape]的工厂类。
 *
 * @author i-f-v
 */
object ShapeFactory {

    fun calculateAreaByShape(shape: Shape) = when (shape) {
        is Shape.Circle -> ShapeName("Circle")
        is Shape.Square -> ShapeName("Square")
    }
}