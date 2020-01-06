package org.clay.learntest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;

/**
 * 一个JUnit Rule就是一个实现了TestRule的类，这些类的作用类似于@Before、@After，是用来在每个测试方法的执行前后执行一些代码的一个方法。
 *
 * 那为什么不直接用这些annotation呢？这是因为它们都只能作用于一个类，如果同一个setup需要在两个类里面同时使用，那么你就要在两个测试类里面定义相同的@Before方法，
 * 然后里面写相同的代码，这就造成了代码重复。
 *
 * 此外，JUnit Rule还能做一些@Before这些Annotation做不到的事情，那就是他们可以动态的获取将要运行的测试类、测试方法的信息。这个在接下来的一个例子里面可以看到。
 */
public class JunitRuleTest {

    /**
     * 那么，对于当前这个JunitRuleTest的每一个测试方法。它们的运行时间都不能超过1秒钟，不然就会标志为失败。
     * 而它的实现方式就是在每个方法测试之前都会记录一下时间戳，然后开始倒计时，1秒钟之后如果方法还没有运行结束，就把结果标记为失败。
     *
     * 这里需要注意的一点是Rule需要是public field
     */
    @Rule
    public Timeout timeout = new Timeout(1000);  //使用Timeout这个Rule，

    /**
     * 使用自定义的Rule
     */
    @Rule
    public MethodNameRule methodNameRule = new MethodNameRule();

    @Test
    public void testMethod1() throws Exception {
        //your tests
        //Thread.currentThread().sleep(2000);
    }

    @Test
    public void testMethod2() throws Exception {
        assertEquals(4, 2 + 2);
    }

    //other test methods
}
