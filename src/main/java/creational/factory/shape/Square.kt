package creational.factory.shape

/**
 * 表示正方形的数据类。
 *
 * @param length 半径
 * @author i-f-v
 */
data class Square(
    val length: Double?
) : Shape {

    override fun calcArea(): Double? = length?.apply {
        length * length
    }
}
