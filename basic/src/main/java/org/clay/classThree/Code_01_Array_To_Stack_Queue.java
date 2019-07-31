package org.clay.classThree;

public class Code_01_Array_To_Stack_Queue {

    public static class ArrayStack {//固定数组，实现栈
        private Integer[] arr;
        private Integer index;//如果把数组竖着排，index就是第一个。

        public ArrayStack(int initSize) {
            if (initSize < 0) {
                throw new IllegalArgumentException("The init size is less than 0");
            }
            arr = new Integer[initSize];
            index = 0;
        }

        public void push(Integer x) {
            if (index == arr.length) {    //先赋值，再自增，所以index最终不能使用的位置是arr.length，也就是数组再向上一个位置。
                throw new IllegalArgumentException("stack is full");
            }
            arr[index++] = x;
        }

        public Integer pop() {
            if (index == 0) {     //先自减，再赋值,所以index最终不能使用的位置是0，也就是指向数组最下方的位置。
                throw new IllegalArgumentException("stack is empty");
            }
            return arr[--index];
        }
    }

    /**
     * 相当于一个循环数组
     * start 永远追着end跑
     * size 就相当于他们之间的距离，所以不能超过初始设定的数组长度。
     * start都在向下移动，所以都是++操作。
     */
    public static class ArrayQueue {
        private Integer[] arr;
        private Integer size;
        private Integer start;
        private Integer end;

        public ArrayQueue(int initSize) {
            if (initSize < 0) {
                throw new IllegalArgumentException("The init size is less than 0");
            }
            arr = new Integer[initSize];
            size = 0;
            start = 0;  //first 指向第一个
            end = 0;    //end 指向最后一个
        }

        public Integer peek() {
            if (size == 0) {
                return null;
            }
            return arr[start];
        }

        public void push(Integer x) {
            if (size == arr.length) {
                throw new IllegalArgumentException("stack is full");
            }
            size++;//size 自增1.
            arr[end] = x;
            end = (end == arr.length - 1) ? 0 : end++;
        }

        public Integer poll(){
            if(size == 0){
                throw new IllegalArgumentException("stack is empty");
            }
            size--; //poll一个相当于追上了一步，所以size（两人之间的距离-1）
            int temp = start;
            start = (start == arr.length - 1) ? 0 : start++;//都在向下跑，且初始值都是0，所以判断条件都是 == arr.length-1，意思就是跑到底了。
            return arr[temp];
        }
    }
}
