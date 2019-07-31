package org.clay.classThree_Re_1;

public class Array_to_Stack_Queue {

    public static class ArrayStack {    //固定数组，实现栈

        int[] arr;

        public ArrayStack(int init) {
            arr = new int[init];
        }

        int index = 0;

        public void push(Integer x) {
            if (index < arr.length) {
                arr[index++] = x;
            }
        }

        public Integer pop() {

            if (index > 0) {
                return arr[--index];
            }
            return null;
        }
    }

    public static class ArrayQueue {    //固定数组，实现队列

        int[] arr;
        int size;

        public ArrayQueue(int init) {
            arr = new int[init];
            size = 0;
        }

        int start = 0;
        int end = 0;

        public void push(Integer x) {

            if(size == 3){

            }
            size++;
            arr[end] = x;
            end = (end == arr.length - 1) ? 0 : end++;
        }

        public Integer poll() {

            if(size == 0){

            }
            size--;
            int temp = arr[start];
            start = (start == arr.length - 1) ? 0 : start++;
            return temp;
        }
    }
}
