package org.clay.finalTest;


public class TestFinal {

    /**
     * 赋值时机
     * 类变量(static修饰的变量):声明变量的时候直接赋初值、在静态代码块中给类变量赋初值
     * 实例变量:声明变量的时候给实例变量赋初值、在非静态初始化块、以及构造器中赋初值
     */

    private final int a = 6;
    private final String str;
    private final double c;

    private final static boolean b;

    //三个赋值时机都没有被赋值，所以报错
    //private final char ch;

    {
        //实例变量可以在非静态初始化块中赋值
        str = "初始化块赋值";
    }

    static {
        //类变量 (静态变量) 不可以在静态初始化块中赋值；
        b = true;
        //非静态变量不可以在静态初始化块中赋值；
        //str = "";
    }

    public TestFinal(){
        //实例变量可以在构造器中赋值
        c = 1.0;
    }

    public static void main(String[] args) {

    }
}
