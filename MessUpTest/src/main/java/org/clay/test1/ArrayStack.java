package org.clay.test1;


public class ArrayStack {

    private int[] arr = null;
    private int index = 0;  //the location of next num


    public ArrayStack(int initSize){

        arr = new int[initSize];
    }

    public void push(int element){

        if(index == arr.length){
            throw new RuntimeException("stack is full");
        }

        arr[index++] = element;
    }

    public int pop(){

        int res = -1;

        if(index == 0){
            throw new RuntimeException("stack is empty");
        }
        res = arr[--index];
        return res;
    }
}
