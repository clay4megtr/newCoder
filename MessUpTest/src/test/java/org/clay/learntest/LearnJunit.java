package org.clay.learntest;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

//maven test 阶段就会跳过这个类
@Ignore
public class LearnJunit {

    Calculator mCalculator;

    //@BeforeClass和@AfterClass
    //跑一个测试类的所有测试方法之前，会执行一次被@BeforeClass修饰的方法，执行完所有测试方法之后，会执行一遍被@AfterClass修饰的方法
    //这两个方法可以用来setup和release一些公共的资源，需要注意的是，被这两个annotation修饰的方法必须是静态的

    //每个方法执行前，都先执行这个方法
    @Before
    public void setup() {
        mCalculator = new Calculator();
    }

    @Test
    public void testAdd() throws Exception {
        int sum = mCalculator.add(1, 2);
        assertEquals(3, sum);
    }

    @Test
    public void testMultiply() throws Exception {
        int product = mCalculator.multiply(2, 4);
        assertEquals(8, product);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test() {
        mCalculator.divide(4, 0);
    }


}
