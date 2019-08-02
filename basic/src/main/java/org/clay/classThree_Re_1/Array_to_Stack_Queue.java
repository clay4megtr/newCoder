package org.clay.classThree_Re_1;

public class Array_to_Stack_Queue {

    public static class ArrayStack {    //固定数组，实现栈

        int[] arr = null;
        int index = 0;

        public ArrayStack(int size){
            arr = new int[size];
        }

        public void push(int element){

            if(index >= arr.length){
                throw new RuntimeException("栈已满");
            }

            arr[index++] = element;
        }

        public Integer pop(){

            if(index == 0){
                return null;
            }

            return arr[--index];
        }
    }

    public static class ArrayQueue {    //固定数组，实现队列

        int[] arr = null;
        int start = 0;
        int end = 0;
        int size = 0;

        public ArrayQueue(int size){
            arr = new int[size];
        }

        public void push(int element){
            if(size == arr.length){
                throw new RuntimeException("队列已满");
            }

            size++;
            arr[end] = element;
            end = end == arr.length-1 ? 0: end++;
        }

        public Integer poll(){
            if(size == 0){
                return null;
            }
            size--;
            int res = arr[start];
            start = start == arr.length-1 ? 0 : start++;
            return res;
        }
    }
}
