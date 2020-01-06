package org.clay.learntest;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * 自定义 Rule
 *
 * 写一个Rule就是implement一个TestRule interface，实现一个叫apply()的方法。这个方法需要返回一个Statement对象。
 * 下面给一个例子，这个 Rule的作用是，在测试方法运行之前，记录测试方法所在的类名和方法名，然后在测试方法运行之后打印出来。
 *
 */
public class MethodNameRule implements TestRule {

    @Override
    public Statement apply(final Statement base, final Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                //想要在测试方法运行之前做一些事情，就在base.evaluate()之前做
                String className = description.getClassName();
                String methodName = description.getMethodName();

                base.evaluate();  //这其实就是运行测试方法

                //想要在测试方法运行之后做一些事情，就在base.evaluate()之后做
                System.out.println("Class name: "+className +", method name: "+methodName);
            }
        };
    }
}
