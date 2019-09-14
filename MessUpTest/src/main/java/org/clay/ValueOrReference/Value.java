package org.clay.ValueOrReference;

/**
 * java中方法参数传递方式是按值传递。
 * 如果参数是基本类型，传递的是基本类型的字面量值的拷贝。
 * 如果参数是引用类型，传递的是该参量所引用的对象在堆中地址值的拷贝。
 */
public class Value {


    public static void main(String[] args) {

        String str = "abc";
        int number = 10;

        TestMethod test = new TestMethod();
        test.foo(number);
        System.out.println(number); //100


        test.foo(str);
        System.out.println(str);  //abc


    }
}
