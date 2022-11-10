package creational.factory.abstractfactory

import kotlin.random.Random

/**
 * 图形的抽象类。
 *
 * @author i-f-v
 */
interface Shape

/**
 * 圆形。
 *
 * @param radius 半径。
 * @author i-f-v
 */
class Circle(radius: Double) : Shape

/**
 * 正方形。
 *
 * @param length 边长。
 * @author i-f-v
 */
class Square(length: Double) : Shape

/**
 * 抽象工厂类。
 *
 * @author i-f-v
 */
abstract class ShapeFactory {

    /**
     * 生成图形的工厂方法。
     *
     * @return 相应的图形对象。
     */
    abstract fun generateShape(): Shape


    companion object {
        /**
         * 根据产品类，生成相应的工厂类。
         *
         * @param T 图形的实现类。为[Shape]类的子类。
         * @return 相应的工厂类。
         */
        inline fun <reified T : Shape> createFactory(): ShapeFactory = when (T::class) {
            Circle::class -> CircleFactory()
            Square::class -> SquareFactory()
            else -> throw IllegalArgumentException()
        }

    }
}

class CircleFactory : ShapeFactory() {

    override fun generateShape(): Shape = Circle(Random.nextDouble() + 1)
}

class SquareFactory : ShapeFactory() {
    override fun generateShape(): Shape = Square(Random.nextDouble() + 1)
}