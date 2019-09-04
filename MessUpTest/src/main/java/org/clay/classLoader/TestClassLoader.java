package org.clay.classLoader;

public class TestClassLoader {

    public static void main(String[] args) {

        //ClassLoader.getSystemClassLoader();  //系统(应用)类加载器(类路径) -> 扩展类加载器 -> 启动类加载器

        String rootDir="/Users/zejian/Downloads/Java8_Action/src/main/java/";
        //创建自定义文件类加载器
        FileClassLoader loader = new FileClassLoader(rootDir);
        FileClassLoader loader2 = new FileClassLoader(rootDir);

        try {
            //加载指定的class文件,调用loadClass()
            Class<?> object1=loader.loadClass("com.zejian.classloader.DemoObj");
            Class<?> object2=loader2.loadClass("com.zejian.classloader.DemoObj");

            System.out.println("loadClass->obj1:"+object1.hashCode());
            System.out.println("loadClass->obj2:"+object2.hashCode());

            //加载指定的class文件,直接调用findClass(),绕过检测机制，创建不同class对象。
            Class<?> object3=loader.findClass("com.zejian.classloader.DemoObj");
            Class<?> object4=loader2.findClass("com.zejian.classloader.DemoObj");

            System.out.println("loadClass->obj3:"+object3.hashCode());
            System.out.println("loadClass->obj4:"+object4.hashCode());

            /**
             * 输出结果:
             * loadClass->obj1:644117698
             loadClass->obj2:644117698   这两个是同一个实例，因为loadClass中缓存的原因；

             findClass->obj3:723074861
             findClass->obj4:895328852  直接findClass 不会去找缓存，也跳过了双亲委派模型，所以是两个不同的实例
             */

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadClass() throws ClassNotFoundException{

        //ClassLoader
        //如果不想重新定义加载类的规则，也没有复杂的逻辑，只想在运行时加载自己指定的类，那么我们可以直接使用
        this.getClass().getClassLoader().loadClass("className");


        //findClass: 自定义的类加载逻辑
        /**
         * 在JDK1.2之前，在自定义类加载时，总会去继承ClassLoader类并重写loadClass方法，从而实现自定义的类加载类，但是在JDK1.2之后已不再建议用户去覆盖loadClass()方法，
         * 而是建议把自定义的类加载逻辑写在findClass()方法中，从ClassLoader的源码中可知，findClass()方法是在loadClass()方法中被调用的，
         * 当loadClass()方法中父加载器加载失败后，则会调用自己的findClass()方法来完成类加载，这样就可以保证自定义的类加载器也符合双亲委托模式。
         * 需要注意的是ClassLoader类中并没有实现findClass()方法的具体代码逻辑，取而代之的是抛出ClassNotFoundException异常，
         * 同时应该知道的是findClass方法通常是和defineClass方法一起使用的(如下)
         */

        //defineClass: 将byte字节流解析成JVM能够识别的Class对象
        /**
         * 通过这个方法不仅能够通过class文件实例化class对象，也可以通过其他方式实例化class对象，如通过网络接收一个类的字节码，
         * 然后转换为byte字节流创建对应的Class对象，defineClass()方法通常与findClass()方法一起使用，
         * 一般情况下，在自定义类加载器时，会直接覆盖ClassLoader的findClass()方法并编写加载规则，取得要加载类的字节码后转换成流，
         * 然后调用defineClass()方法生成类的Class对象，简单例子如下：
         */
        /*protected Class<?> findClass(String name) throws ClassNotFoundException {
            // 获取类的字节数组
            byte[] classData = getClassData(name);
            if (classData == null) {
                throw new ClassNotFoundException();
            } else {
                //使用defineClass生成class对象
                return defineClass(name, classData, 0, classData.length);
            }
        }*/

        //URLClassLoader,具体的实现
        /**
         * ClassLoader是一个抽象类，很多方法是空的没有实现，比如 findClass()、findResource()等。而URLClassLoader这个实现类为这些方法提供了具体的实现，
         * 并新增了URLClassPath类协助取得Class字节码流等功能，在编写自定义类加载器时，如果没有太过于复杂的需求，可以直接继承URLClassLoader类，
         * 这样就可以避免自己去编写findClass()方法及其获取字节码流的方式，使自定义类加载器编写更加简洁
         */
        /**
         * URLClassPath类，通过这个类就可以找到要加载的字节码流，也就是说 URLClassPath 类负责找到要加载的字节码，再读取成字节流，最后通过defineClass()方法创建类的Class对象。
         * 其构造方法都有一个必须传递的参数URL[]，该参数的元素是代表字节码文件的路径，代表类加载器要去哪个路径找要加载的class文件，
         * 在创建URLClassPath对象时，会根据传递过来的URL数组中的路径判断是文件还是jar包，然后根据不同的路径创建FileLoader或者JarLoader或默认Loader类去加载相应路径下的class文件
         * 当JVM调用findClass()方法时，就由这3个加载器中的一个将class文件的字节码流加载到内存中，最后利用字节码流创建类的class对象
         */

        /**
         * 如果我们在定义类加载器时选择继承ClassLoader类而非URLClassLoader，必须手动编写findclass()方法的加载逻辑以及获取字节码流的逻辑
         */

        /**
         *           URLClassLoader
         *                |
         *  AppClassLoader  ExtClassLoader
         *  AppClassLoader 和 ExtClassLoader 都是继承自 URLClassLoader 的，他们是被Launcher加载的，
         */


        /**
         * 在JVM中表示两个class对象是否为同一个类对象存在两个必要条件
         * 1.类的完整类名必须一致，包括包名。
         * 2.加载这个类的ClassLoader(指ClassLoader实例对象)必须相同。
         */
        /**
         * 也就是说，在JVM中，即使这个两个类对象(class对象)来源同一个Class文件，被同一个虚拟机所加载，但只要加载它们的ClassLoader实例对象不同，
         * 那么这两个类对象也是不相等的，这是因为不同的ClassLoader实例对象都拥有不同的独立的类名称空间，所以加载的class对象也会存在不同的类名空间中，
         * 但前提是覆写loadclass方法，从前面双亲委派模式对loadClass()方法的源码分析中可以知，在方法第一步会通过
         * Class<?> c = findLoadedClass(name);
         * 从缓存查找，类名完整名称相同则不会再次被加载，因此我们必须绕过缓存查询才能重新加载class对象。当然也可直接调用findClass()方法，这样也避免从缓存查找,
         * 但是这样也跳过了双亲委派模型
         */



        //线程上下文类加载器
        //双亲委派模型的破坏者；(jdbc) rt.jar中的DriverManager是启动类加载器加载的，MySql.jar是放在classPath的，无法让启动类加载器加载，
        //但是DriverManager又必须访问第三方实现，所以就会委托 线程上下文类加载器 去加载classPath下的第三方实现，

        /**
         * 很明显了确实通过线程上下文类加载器加载的，实际上核心包的SPI类对外部实现类的加载都是基于线程上下文类加载器执行的，
         * 通过这种方式实现了Java核心代码内部去调用外部实现类。我们知道线程上下文类加载器默认情况下就是AppClassLoader，那为什么不直接通过getSystemClassLoader()
         * 获取类加载器来加载classpath路径下的类的呢？其实是可行的，但这种直接使用getSystemClassLoader()方法获取AppClassLoader加载类有一个缺点，
         * 那就是代码部署到不同服务时会出现问题，如把代码部署到Java Web应用服务或者EJB之类的服务将会出问题，因为这些服务使用的线程上下文类加载器并非AppClassLoader，
         * 而是Java Web应用服自家的类加载器，类加载器不同，所以我们应用该少用getSystemClassLoader()。
         * 总之不同的服务使用的可能默认ClassLoader是不同的，但使用线程上下文类加载器总能获取到与当前程序执行相同的ClassLoader，从而避免不必要的问题。
         */
    }
}
