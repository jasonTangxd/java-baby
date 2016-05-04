package cn.xxo.momo.clazz;

/**
 * 匿名内部类
 * Created by Jason on 2016/3/25.
 */
public class InnerClass {

    public void test(Bird bird) {
        System.out.println(bird.getName() + "能够飞 " + bird.fly() + "米");
    }

    public static void main(String[] args) {
        InnerClass test = new InnerClass();
        test.test(new Bird() {

            public int fly() {
                return 10000;

            }

            public String getName() {
                return "大雁";
            }

        });
    }

}

abstract class Bird {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract int fly();
}

