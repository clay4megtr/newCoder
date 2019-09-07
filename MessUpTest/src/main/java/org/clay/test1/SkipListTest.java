package org.clay.test1;

import java.util.ArrayList;

public class SkipListTest {

    public static class SkipListNode{
        private Integer value;
        private ArrayList<SkipListNode> nextNodes;

        public SkipListNode(Integer value){
            this.value = value;
            this.nextNodes = new ArrayList<>();
        }
    }

    public static class SkipList{

        private SkipListNode head;  //头结点，巨小
        private int maxLevel;  //最大层数
        private int size;
        private static final double PROBABILITY = 0.5;

        public SkipList(){
            this.head = new SkipListNode(null);
            maxLevel = 0;
            size = 0;
            head.nextNodes.add(null);  //0位置指向null，也就是说0位置废弃了！
        }

        public void add(Integer newValue){
            if(!contains(newValue)){
                size ++;
                int level = 0;
                while(Math.random() < PROBABILITY){
                    level ++;
                }
                while(level > maxLevel){
                    head.nextNodes.add(null);
                    maxLevel ++;
                }
                SkipListNode newNode = new SkipListNode(newValue);
                SkipListNode current = head;
                int levelAll = maxLevel;
                do{
                    current = findNext(newValue,current,levelAll);
                    if(levelAll <= level){
                        newNode.nextNodes.add(0,current.nextNodes.get(level));
                        current.nextNodes.set(level,newNode);
                        level--;
                    }

                }while (levelAll-- > 0);
            }
        }

        /**
         * @param e 要插入的新值
         * @param current 当前节点，比如一开始是head节点
         * @param level  当前层数,比如一开始是最大值
         * @return
         */
        public SkipListNode findNext(Integer e,SkipListNode current,int level){
            SkipListNode next = current.nextNodes.get(level);

            while(next != null){
                if(current.value > e){
                    break;
                }
                current = next;
                next = current.nextNodes.get(level);
            }
            return current;
        }

        public boolean contains(int value){
            if(size == 0){
                return false;
            }

            return false;
        }
    }
}
