package org.clay.test2;

import java.util.ArrayList;
import java.util.List;

public class ConditionChange {
    private static List<String> lockObject = new ArrayList();


    public static void main(String[] args) {
        Consumer consumer1 = new Consumer(lockObject);
        consumer1.setName("consumer1");
        Consumer consumer2 = new Consumer(lockObject);
        consumer2.setName("consumer2");

        Productor productor = new Productor(lockObject);
        productor.setName("productor");

        consumer1.start();
        consumer2.start();
        productor.start();
    }

    static class Consumer extends Thread {
        private List<String> lock;

        public Consumer(List lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            synchronized (lock) {
                try {
                    //这里使用if的话，就会存在wait条件变化造成程序错误的问题
                    while (lock.isEmpty()) {
                        System.out.println(Thread.currentThread().getName() + " list为空");
                        System.out.println(Thread.currentThread().getName() + " 调用wait方法");
                        lock.wait();
                        System.out.println(Thread.currentThread().getName() + "  wait方法结束");
                    }
                    String element = lock.remove(0);
                    System.out.println(Thread.currentThread().getName() + " 取出第一个元素为：" + element);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    static class Productor extends Thread {
        private List<String> lock;

        public Productor(List lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + " 开始添加元素");
                lock.add(Thread.currentThread().getName());
                lock.notifyAll();
            }
        }

    }
}