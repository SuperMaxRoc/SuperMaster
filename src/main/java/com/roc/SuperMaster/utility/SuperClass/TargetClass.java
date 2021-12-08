package com.roc.SuperMaster.utility.SuperClass;

/**
 * @Author Roc
 * @Date 2021/12/8 9:11
 * @Version 1.0.0
 * @ClassName TargetClass.java
 * @Description 编译及反编译探究类内部的加载顺序问题
 * @UpdateUser Roc
 */
public class TargetClass {

    public static final String NAME = "Hello1";

    static {
        System.out.println(NAME);
        System.out.println("静态代码块2");
    }

    public int age = 24;

    {
        System.out.println(age);
        System.out.println("非静态代码块3");
    }

    public TargetClass() {
        System.out.println("无参构造方法4");
    }

    public TargetClass(int age) {
        this.age = age;
        System.out.println("有参构造方法4");
    }

    public static void main(String[] args) {
        TargetClass targetClass = new TargetClass();
        targetClass.sayHello();
    }

    public void sayHello() {
        {
            System.out.println("普通代码块5");
        }
    }

    /*反编译得到的源码文件
    //
    // Source code recreated from a .class file by IntelliJ IDEA
    // (powered by FernFlower decompiler)
    //

public class TargetClass {
    public static final String NAME = "Hello1";
    public int age = 24;

    public TargetClass() {
        System.out.println(this.age);
        System.out.println("非静态代码块3");
        System.out.println("无参构造方法4");
    }

    public TargetClass(int var1) {
        System.out.println(this.age);
        System.out.println("非静态代码块3");
        this.age = var1;
        System.out.println("有参构造方法4");
    }

    public void sayHello() {
        System.out.println("普通代码块5");
    }

    public static void main(String[] var0) {
        TargetClass var1 = new TargetClass();
        var1.sayHello();
    }

    static {
        System.out.println("Hello1");
        System.out.println("静态代码块2");
    }
}
     */

}
