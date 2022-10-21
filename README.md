# DesignPatternStudy
 Design pattern study and practice.

# 设计模式的原则

- 单一职责（Single Responsibilities Principle）
  > 引起某一个类发生变化的原因只能是一个。
- 接口隔离（Interface Segregation Principle）
  > 使用多个隔离的接口代替单个复杂接口，降低接口之间的**耦合度**。
- 依赖反转（Dependence Inversion Principle）
  > 针对接口编程，依赖于“**抽象**” 。
- 里氏替换（Liskov Substitution Principle）
  > 基类可以出现的地方，都可以**用子类替换**。
- 迪米特原则（Demeter Principle）
  > **实体之间**应该尽量少地发生相互作用，使得系统功能模块相对独立。
- 开闭原则（Open Close Principle）
  > 对扩展开放，对修改关闭。即**高扩展性**。
- 合成复用（Composite Reuse Principle）
  > 尽量使用**合成**或**聚合**来代替**继承**。

# 具体内容

## 创建型模式（Creational Pattern）

### 单例模式（Singleton Pattern）

#### 饿汉式（静态变量实现）
> 意为在类加载时就创建单例对象。

##### 优点
- 写法简单。
- 类装载时完成实例化，避免线程同步。

##### 缺点
- 因为类装载时完成实例化，没有实现“**懒加载**”。如果是一直没有使用这个实例，会造成**内存浪费**。

#### 饿汉式（静态代码块实现）

##### 优缺点
与 **饿汉式（静态变量实现）** 一致。

#### 懒汉式（非线程安全的写法）
> 意为在类加载时不创建单例对象，在调用单例对象时才创建。

##### 优点
- 实现了“懒加载”。

##### 缺点
- 线程非安全。在未初始化单例时，若两个线程同时执行获取单例的方法，这时会产生多个实例。

> 实际开发不推荐使用。

#### 懒汉式（线程安全，同步锁方法）

实现方法是对`Singleton`类加`synchronized`锁。

然而实际上不能实现线程安全。因为每次获取都会先进入`if`判断语句，依然会有判断条件同时为空的情况。

##### 优点
- 线程安全。

##### 缺点
- 效率低。同步锁包含了`if`语句，实例创建后的方法需要获得实例时不需要判断实例为空。

> 实际开发不推荐使用。

#### 懒汉式（同步锁代码块）实际上线程非安全

#### 双重检查（Double Check Lock）
> 使用两次判空。
> **推荐使用**。

##### 优点
- 同时实现懒加载和线程安全，且避免反复执行创建对象判断而低效率。

#### 静态内部类（Static Internal Class）
> 将实例用一个静态内部类包装。
> **推荐使用**。

##### 优点
- 在没有调用获取单例的方法时，单例内部类不会装载，实现“懒加载”。
- 调用获取单例的方法以后，单例的内部类开始装载，此时由JVM保证线程安全。

#### 枚举
> 利用JVM装载枚举类的机制。在实现“懒加载”、线程安全、高效率的前提下。还是唯一一个支持反射的单例模式。

## 结构型模式（Structural Pattern）

## 行为型模式（Behavioral Pattern）

