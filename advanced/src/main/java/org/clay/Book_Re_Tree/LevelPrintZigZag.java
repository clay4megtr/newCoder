package org.clay.Book_Re_Tree;


import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 层序打印 (分层时换行)
 * 蛇形打印 (分层时换行)
 */
public class LevelPrintZigZag {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * BFS的改写
     * last：当前行的最右节点
     * nLast：下一行的最右节点
     * 假设每一层都做从左到右的宽度优先遍历，如果发现遍历的节点等于Last了，此时说明该换行了，换行之后，只要让last=nLast，就可以继续下一行的打印，重复此过程，直到所有的节点打印完
     * 问题：如何更新nLast，只需要让nLast一直跟踪记录Queue中的最新加入的节点即可，因为最新加入的节点一定是目前已经发现的下一行的最右节点，所以当当前行打印完时，nLast一定是下一行所有节点中的最右节点
     */
    public static void levelPrint(Node head){

        Queue<Node> queue = new LinkedList<>();
        //队列的添加方法是offer，提取方法是poll, addLast和pollFirst是双端队列的方法
        queue.offer(head);

        Node last = head;
        Node nLast = null;

        while(!queue.isEmpty()){

            Node cur = queue.poll();
            System.out.print(cur.value + "  ");

            if(cur.left != null){
                queue.offer(cur.left);
                nLast = cur.left;
            }
            if(cur.right != null){
                queue.offer(cur.right);
                nLast = cur.right;
            }

            if(cur == last){
                System.out.println();  //换行
                last = nLast;
            }
        }
    }

    /**
     * 蛇形打印，
     * 使用双端队列结构，
     * > 如果当前层是从左到右打印，则弹出时从双端队列的头部弹，加入子节点时从双端队列的尾部加，先加左孩子再加右孩子；
     * > 如果当前层是从右到左打印，则弹出时从双端队列的尾部弹，加入子节点时从双端队列的头部加，先加右孩子再加左孩子；
     * 此时问题变成了：何时应该切换打印顺序？这一层遍历完了时切换，所以本质上还是如何确定每一层最后一个节点的问题。
     * 在打印的过程中，下一层最后打印的节点是  === 当前层有孩子的节点中最先进入双端队列的节点 ===
     *
     */
    public static void zigZag(Node head){

        Deque<Node> dq = new LinkedList<>();
        boolean lr = true;
        Node last = head;
        Node nLast = null;
        dq.offerLast(head);

        while(!dq.isEmpty()){
            if(lr){     //从左到右
                head = dq.pollFirst(); //从头部弹，
                if(head.left != null){  //先弹左
                    nLast = nLast == null ? head.left : nLast;
                    dq.offerLast(head.left);  //从尾部进
                }
                if(head.right != null){ //再弹右
                    nLast = nLast == null ? head.right : nLast;
                    dq.offerLast(head.right);
                }
            }else{  //从右到左
                head = dq.pollLast();  //从尾部弹
                if(head.right != null){  //先弹右
                    nLast = nLast == null ? head.right : nLast;
                    dq.offerFirst(head.right);
                }
                if(head.left != null){  //再弹左
                    nLast = nLast == null ? head.left : nLast;
                    dq.offerFirst(head.left);
                }
            }
            System.out.print(head.value + "  ");

            if(head == last){ //当前节点是当前层的最后一个节点了，该换行了
                System.out.println();
                last = nLast;
                nLast = null;  //** 这里不要忘记换行之后，下一层的最后一个节点要置为null，这样才有机会重新更新再下一层的最后一个节点
                lr = !lr;
            }
        }
    }

    public static void main(String[] args) {

        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);

        node.left.left = new Node(4);
        node.right.left = new Node(5);
        node.right.right = new Node(6);

        node.right.left.left = new Node(7);
        node.right.left.right = new Node(8);

        //levelPrint(node);

        zigZag(node);
    }
}