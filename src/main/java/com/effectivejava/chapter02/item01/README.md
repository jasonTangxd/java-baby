
## 一、考虑用静态工厂方法代替构造器：

- 构造器是创建一个对象实例最基本也最通用的方法，大部分开发者在使用某个class的时候，首先需要考虑的就是如何构造和初始化一个对象示例，
而构造的方式首先考虑到的就是通过构造函数来完成，
因此在看javadoc中的文档时首先关注的函数也是构造器。
然而在有些时候构造器并非我们唯一的选择，通过反射也是可以轻松达到的。

- 我们这里主要提到的方式是通过静态类工厂的方式来创建class的实例，如：
``` java
    public static Boolean valueOf(boolean b) {
        return b ? Boolean.TRUE : Boolean.FALSE;
    }
```

- 静态工厂方法和构造器不同有以下主要优势：
1.    有意义的名称
2.    不必在每次调用它们的时候创建一个新的对象
3.    可以返回原返回类型的任何子类型
4.    在创建参数化类型实例的时候，它们使代码变得更加简洁。
``` java
      public static <K,V> HashMap<K,V> newInstance() {
          return new HashMap<K,V>();
      }
      Map<String,String> m = MyHashMap.newInstance();
```

- 参考
[http://www.cnblogs.com/stephen-liu74/archive/2012/01/13/2228354.html](http://www.cnblogs.com/stephen-liu74/archive/2012/01/13/2228354.html)