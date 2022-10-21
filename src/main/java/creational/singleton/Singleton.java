package creational.singleton;

/**
 * 单例模式。
 * 由于Kotlin语言支持单例模式，所以用Java实现单例。
 *
 * @author i-f-v
 */
public class Singleton {

    /**
     * 饿汉式（静态变量）。
     *
     * @author i-f-v
     */
    static class SingletonHungryByStaticVar {

        // 私有构造方法。
        private SingletonHungryByStaticVar() {
        }

        // 内部类创建实例。
        private final static SingletonHungryByStaticVar SINGLETON_INSTANCE =
                new SingletonHungryByStaticVar();

        /**
         * 提供公有静态方法获取实例对象。
         *
         * @return 返回获取的单例对象。
         */
        public static SingletonHungryByStaticVar getInstance() {
            return SINGLETON_INSTANCE;
        }
    }

    /**
     * 饿汉式（静态代码块）。
     *
     * @author i-f-v
     */
    static class SingletonHungryByStaticCodeBlock {

        // 私有构造方法。
        private SingletonHungryByStaticCodeBlock() {
        }

        // 私有静态实例，但未初始化。
        private static final SingletonHungryByStaticCodeBlock SINGLETON_INSTANCE;

        static {// 静态代码块创建单例对象。
            SINGLETON_INSTANCE = new SingletonHungryByStaticCodeBlock();
        }

        /**
         * 提供公有静态方法获取实例对象。
         *
         * @return 返回获取的单例对象。
         */
        public static SingletonHungryByStaticCodeBlock getInstance() {
            return SINGLETON_INSTANCE;
        }
    }

    /**
     * 懒汉式（线程非安全）。
     *
     * @author i-f-v
     */
    static class SingletonLazyNonThreadSafe {

        private static SingletonLazyNonThreadSafe singletonInstance;

        private SingletonLazyNonThreadSafe() {
        }

        /**
         * 公有方法获取单例。若单例未初始化创建则创建单例对象。
         * <p>
         * 非线程安全。
         *
         * @return 返回单例对象。
         */
        public static SingletonLazyNonThreadSafe getInstance() {
            if (singletonInstance == null)
                singletonInstance = new SingletonLazyNonThreadSafe();
            return singletonInstance;
        }
    }

    /**
     * 懒汉式（线程安全）。
     *
     * @author i-f-v
     */
    static class SingletonLazyThreadSafe {

        private static SingletonLazyThreadSafe singletonInstance;

        private SingletonLazyThreadSafe() {
        }

        /**
         * 公有方法获取单例。若单例未初始化创建则创建单例对象。
         * <p>
         * 通过同步锁方法实现线程安全。但是效率低。
         *
         * @return 返回单例对象。
         */
        public static synchronized SingletonLazyThreadSafe getInstance() {
            if (singletonInstance == null)
                singletonInstance = new SingletonLazyThreadSafe();
            return singletonInstance;
        }
    }

    /**
     * 双重检查。
     *
     * @author i-f-v
     */
    static class SingletonDoubleCheck {

        // volatile 关键字修饰的单例。作用是多线程环境下禁止指令重排序，这里是指两次判空的if语句。
        private static volatile SingletonDoubleCheck singletonInstance;

        private SingletonDoubleCheck() {
        }

        /**
         * 公有方法获取单例。若单例未初始化创建则创建单例对象。
         * <p>
         * 双重检查实现线程安全。
         *
         * @return 返回单例对象。
         */
        public static SingletonDoubleCheck getInstance() {
            if (singletonInstance == null) {
                synchronized (SingletonDoubleCheck.class) {
                    // 等待同步的线程在前一个线程创建结束后，判断单例不等于null，所以不会重复创建
                    if (singletonInstance == null) {
                        singletonInstance = new SingletonDoubleCheck();
                    }
                }
            }
            return singletonInstance;
        }
    }

    /**
     * 静态内部类。
     *
     * @author i-f-v
     */
    static class SingletonStaticInternalClass {

        private SingletonStaticInternalClass() {
        }

        /**
         * 用于包装单例的内部类。保证线程安全。
         *
         * @author i-f-v
         */
        static class SingletonWrapper {
            private final static SingletonStaticInternalClass SINGLETON_INSTANCE =
                    new SingletonStaticInternalClass();
        }

        /**
         * 公有方法获取单例。若单例未初始化创建则创建单例对象。
         * <p>
         * 通过静态内部类实现线程安全，且实现了“懒加载”。
         *
         * @return 返回单例对象
         */
        public static SingletonStaticInternalClass getInstance() {
            return SingletonWrapper.SINGLETON_INSTANCE;
        }
    }

    /**
     * 用于实现单例的枚举类。
     *
     * @author i-f-v
     */
    enum SingletonEnum {
        // 直接通过Singleton.INSTANCE可以获取单例
        INSTANCE;

        /**
         * 调用单例的方法。
         */
        public void method() {
            System.out.println("This is a singleton object.");
        }
    }
}
