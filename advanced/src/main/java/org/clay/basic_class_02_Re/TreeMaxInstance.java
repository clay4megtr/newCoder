package org.clay.basic_class_02_Re;

public class TreeMaxInstance {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 返回结构
     * 1.最大二叉搜索子树的大小
     * 2.最大二叉搜索子树的头部
     * 3.最大值
     * 4.最小值
     */
    public static class ReturnType{
        private int max_instance;
        private int h;

        public ReturnType(int max_instance,int h){
            this.max_instance = max_instance;
            this.h = h;
        }
    }

    public static ReturnType process(Node head){

        if(head == null){
            return new ReturnType(0,0);
        }

        ReturnType left_res = process(head.left);
        ReturnType right_res = process(head.right);

        int p1 = left_res.max_instance;
        int p2 = right_res.max_instance;

        int max_instance = Math.max(Math.max(p1,p2),left_res.h + right_res.h + 1);

        int h = Math.max(left_res.h,right_res.h) + 1;

        return new ReturnType(max_instance,h);
    }
}
