package org.clay.test2;

public class FinalExample {
    //在声明final实例成员变量时进行赋值
    private final static Person person = new Person(24, 170);
    public static void main(String[] args) {
        //对final引用数据类型person进行更改
        person.age = 22;
        System.out.println(person.toString());
    }
    static class Person {
        private int age;
        private int height;

        public Person(int age, int height) {
            this.age = age;
            this.height = height;
        }
        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    ", height=" + height +
                    '}';
        }
    }
}
