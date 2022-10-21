package factory

import creational.factory.factory.ShapeFactory
import org.junit.jupiter.api.Test

/**
 * [ShapeFactory]的测试类。
 *
 * @author i-f-v
 */
class ShapeFactoryTest {

    /**
     * 测试工厂模式创建和方法调用。
     */
    @Test
    fun createTest() {

        assert(circle?.calcArea() == null) {
            println("Circle 创建失败")
        }
        assert(square?.calcArea() == null) {
            println("Square 创建失败")
        }
    }

    companion object {
        var circle = ShapeFactory().getShape("Circle")
        var square = ShapeFactory().getShape("Square")
    }
}