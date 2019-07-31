package org.clay.test1;

public class ArrayQueue {

    private int[] arr;
    private int size;
    private int start; //the number we want
    private int end;    //the location of next push number

    public ArrayQueue(int size){
        arr = new int[size];
        this.size = 0;
        this.start = 0;
        this.end = 0;
    }

    public void push(int element){

        if(size == arr.length){
            throw new RuntimeException("the queue is full");
        }

        size++;
        arr[end] = element;
        end = end == arr.length-1 ? 0 : ++end;
    }

    public int poll(){

        if(size == 0){
            throw new IllegalArgumentException("queue is empty");
        }
        size--; //poll一个相当于追上了一步，所以size（两人之间的距离-1）
        int temp = start;
        start = (start == arr.length - 1) ? 0 : ++start;//都在向下跑，且初始值都是0，所以判断条件都是 == arr.length-1，意思就是跑到底了。
        return arr[temp];
    }

    public static void main(String[] args) {

        ArrayQueue aq = new ArrayQueue(4);

        aq.push(4);
        aq.push(5);
        aq.push(6);
        aq.push(7);

        System.out.println(aq.poll());
        System.out.println(aq.poll());
        System.out.println(aq.poll());
        System.out.println(aq.poll());

        aq.push(1);
        aq.push(2);
        System.out.println(aq.poll());
        System.out.println(aq.poll());
    }
}
