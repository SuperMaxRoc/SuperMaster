package com.roc.SuperMaster.utility.superClass;

/**
 * @Author Roc
 * @Date 2021/12/8 9:09
 * @Version 1.0.0
 * @ClassName SonClass.java
 * @Description 探究父类与子类的加载顺序
 * @UpdateUser Roc
 */
public class SonClass extends FatherClass {

    public static final String SON_NAME = "I am Son.3";

    public int age = 24;

    static {
        System.out.println(SON_NAME);
        System.out.println("子类：静态代码块4");
    }

    {
        System.out.println("子类：非静态代码块7");
    }

    public SonClass() {
        System.out.println("子类：无参构造方法8");
    }

    public SonClass(int age) {
        this.age = age;
        System.out.println("子类：有参构造方法8");
    }

    //测试时请将注释解开
    //new 一个Son类
    //public static void main(String[] args) {
    //    SonClass sonClass = new SonClass();
    //    sonClass.sayHello();
    //    /**
    //     * 执行顺序：
    //     *
    //     * I am you Father.1
    //     * 父类：静态代码块2
    //     * I am Son.3
    //     * 子类：静态代码块4
    //     * 父类：非静态代码块5
    //     * 父类：无参构造方法6
    //     * 子类：非静态代码块7
    //     * 子类：无参构造方法8
    //     * 父类：普通代码块
    //     * */
    //
    //    //打印当前主机环境下类加载器能加载的jar包的路径，熟悉的就包含rt包、ext包等
    //    System.out.println(System.getProperty("java.class.path"));
    //}

}
