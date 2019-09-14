package org.clay.ValueOrReference;

public class TestMethod {

    /**
     * 基本类型
     * 传递过来的是字面量值的一个拷贝，
     */
    void foo(int value) {
        value = 100;
    }


    /**
     * 没有提供改变自身方法的引用类型
     */
    void foo(String text) {
        text = "windows";
    }
}
