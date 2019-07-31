package org.clay.test1;

import java.util.Map;

public class GetCBTNum {

    public static class Node{
        private int val;
        private Node left;
        private Node right;

        public Node(int val){
            this.val = val;
        }
    }


    public static int getNum(Node head){

        if(head == null){
            return 0;
        }

        int heighZ = getHeigh(head);

        int heighR = getHeigh(head.right);

        if(heighR + 1 == heighZ){

            int leftNum = Double.valueOf(Math.pow(2,(heighZ-1))).intValue() - 1;
            int res = leftNum + 1 + getNum(head.right);

            return res;
        }else{
            int rightNum = Double.valueOf(Math.pow(2,(heighZ-2))).intValue() -1;
            return rightNum + 1 + getNum(head.left);
        }

    }

    public static int getHeigh(Node head){
        int heigh = 0;

        while(head != null){
            heigh += 1;
            head = head.left;
        }
        return heigh;
    }

    public static void main(String[] args) {
        /*Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        System.out.println(getNum(head));*/

        System.out.println(1 << 4);
    }
}
