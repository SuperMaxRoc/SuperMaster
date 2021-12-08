package com.roc.SuperMaster.utility.SuperClass;

/**
 * @Author Roc
 * @Date 2021/12/8 9:09
 * @Version 1.0.0
 * @ClassName FatherClass.java
 * @Description 探究父类与子类的加载顺序
 * @UpdateUser Roc
 */
public class FatherClass {

    public static final String FATHER_NAME = "I am you Father.1";

    public int age = 50;

    static {
        System.out.println(FATHER_NAME);
        System.out.println("父类：静态代码块2");
    }

    {
        System.out.println("父类：非静态代码块5");
    }

    public FatherClass() {
        System.out.println("父类：无参构造方法6");
    }

    public FatherClass(int age) {
        this.age = age;
        System.out.println("父类：有参构造方法6");
    }

    public void sayHello(){
        {
            System.out.println("父类：普通代码块");
        }
    }
}
