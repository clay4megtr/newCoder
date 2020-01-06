package org.clay.learntest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FibonacciNumbersTest {
    private static final Logger log = LoggerFactory.getLogger(FibonacciNumbersTest.class);

    @Parameterized.Parameters(name = "{index}: fib({0}={1})")
    public static Collection<Integer[]> data() {
        return Arrays.asList(new Integer[][]{
                {0, 0}, {1, 1}, {2, 1},
                {3, 2}, {4, 3}, {5, 5},
                {6, 8}});
    }

    @Parameterized.Parameter
    public int fInput;

    @Parameterized.Parameter(value = 1)
    public int fExpected;

    @Test
    public void testParemeter(){
        log.info("fExpected {} fib(fInput) {}", fExpected, fib(fInput));
        assertEquals(fExpected, fib(fInput));
    }

    public static int fib(int n) {
        if (n < 2) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }
}
