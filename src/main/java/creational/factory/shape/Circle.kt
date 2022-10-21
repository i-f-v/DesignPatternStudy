package creational.factory.shape

/**
 * 表示圆形的数据类。
 *
 * @param radius 半径
 * @author i-f-v
 */
data class Circle(
    val radius: Double?
) : Shape {

    override fun calcArea(): Double? = radius?.apply {
        Math.PI * radius * radius
    }
}
