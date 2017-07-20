
## 三、用私有构造器或者枚举类型强化Singleton属性

- 对于单实例模式，相信很多开发者并不陌生，然而如何更好更安全的创建单实例对象还是需要一些推敲和斟酌的，
在Java中主要的创建方式有以下三种，我们分别作出解释和适当的比较。
1. 将构造函数私有化，直接通过静态公有的final域字段获取单实例对象：
``` java
public class Elvis {
    public static final Elvis INSTANCE = new Elvis();
    private Elvis() { }

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }

    // This code would normally appear outside the class!
    public static void main(String[] args) {
        Elvis elvis = Elvis.INSTANCE;
        elvis.leaveTheBuilding();
    }
}
```
这样的方式主要优势在于简洁高效，使用者很快就能判定当前类为单实例类，在调用时直接操作Elivs.INSTANCE即可，由于没有函数的调用，因此效率也非常高效。
然而事物是具有一定的双面性的，这种设计方式在一个方向上走的过于极端了，因此他的缺点也会是非常明显的。
如果今后Elvis的使用代码被迁移到多线程的应用环境下了，系统希望能够做到每个线程使用同一个Elvis实例，不同线程之间则使用不同的对象实例。
那么这种创建方式将无法实现该需求，因此需要修改接口以及接口的调用者代码，这样就带来了更高的修改成本。

2. 通过公有域成员的方式返回单实例对象
- 这种方法很清晰的表明了这个类是一个Singleton
``` java
public class Elvis {
    private static final Elvis INSTANCE = new Elvis();
    private Elvis() { }
    public static Elvis getInstance() { return INSTANCE; }

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }

    // This code would normally appear outside the class!
    public static void main(String[] args) {
        Elvis elvis = Elvis.getInstance();
        elvis.leaveTheBuilding();
    }
}
```


3. 实现Singleton类变成可序列化的，紧紧实现序列化是不够的，为了维护并保证Singleton，必须声明所有实例域都是瞬时（transient）的，
并提供一个readResolve方法。
否则，每次反序列化一个序列的实例时，都会创建一个新的实例。
``` java
import java.io.Serializable;

// Serializable singleton with public final field - Page 18
public class Elvis implements Serializable{
    public static final Elvis INSTANCE = new Elvis();
    private Elvis() { }

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }

    private Object readResolve() {
        // Return the one true Elvis and let the garbage collector
        // take care of the Elvis impersonator.
        return INSTANCE;
    }

    // This code would normally appear outside the class!
    public static void main(String[] args) {
        Elvis elvis = Elvis.INSTANCE;
        elvis.leaveTheBuilding();
    }
}
```
这种方法很好的弥补了第一 二种方式的缺陷，如果今后需要适应多线程环境的对象创建逻辑，仅需要修改Elvis的getInstance()方法内部即可，
对用调用者而言则是不变的，这样便极大的缩小了影响的范围。至于效率问题，现今的JVM针对该种函数都做了很好的内联优化，因此不会产生因函数频繁调用而带来的开销。


3.    使用枚举的方式(Java SE5):
- 从JDK 1.5开始，实现Singleton，可以编写一个包含单个元素的枚举类型。
而且可以解决复杂的反序列化或者反射的攻击。
单元素的枚举类型已经成为实现Singleton的最佳方法。

``` java
public enum Elvis {
    INSTANCE;

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }

    // This code would normally appear outside the class!
    public static void main(String[] args) {
        Elvis elvis = Elvis.INSTANCE;
        elvis.leaveTheBuilding();
    }
}
```



- 参考
[http://www.cnblogs.com/stephen-liu74/archive/2012/01/13/2228354.html](http://www.cnblogs.com/stephen-liu74/archive/2012/01/13/2228354.html)
[http://blog.csdn.net/partner4java/article/details/7059280](http://blog.csdn.net/partner4java/article/details/7059280)