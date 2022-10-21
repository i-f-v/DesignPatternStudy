package creational.factory.factory

import creational.factory.shape.Circle
import creational.factory.shape.Shape
import creational.factory.shape.Square

/**
 * [Shape]的工厂类。
 *
 * @author i-f-v
 */
class ShapeFactory {

    /**
     * 根据图形名称获取相应的图形对象。
     *
     * @param shapeName 图形的名称。
     * @return 获得的[Shape]对象。
     * @author i-f-v
     */
    fun getShape(shapeName: String): Shape? = when (shapeName) {
        "Circle" -> Circle(null)
        "Square" -> Square(null)
        else -> null
    }
}