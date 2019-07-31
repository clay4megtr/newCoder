package org.clay.advanced_class_04;

import java.util.*;

public class Code_01_Building_Outline {

    public static class Node {
        public boolean isUp; //上还是下
        public int posi;  //哪个位置
        public int h;   //哪个高度

        public Node(boolean isAddHeight, int position, int height) {
            isUp = isAddHeight;
            posi = position;
            h = height;
        }
    }

    //比较器
    public static class NodeComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            if (o1.posi != o2.posi) {
                return o1.posi - o2.posi;
            }
            //相同的高度，上的位置排在前面，下的位置排在后面，
            if (o1.isUp != o2.isUp) {
                return o1.isUp ? -1 : 1;
            }
            return 0;
        }
    }

    /**
     * @param buildings n行3列的矩阵，n就是大楼的个数
     */
    public static List<List<Integer>> buildingOutline(int[][] buildings) {
        Node[] nodes = new Node[buildings.length * 2];//生成的节点个数是大楼个数的两倍；
        for (int i = 0; i < buildings.length; i++) {
            //0号大楼的位置放在0，1位置，1号大楼放在2，3位置，等
            nodes[i * 2] = new Node(true, buildings[i][0], buildings[i][2]);// true 表示上
            nodes[i * 2 + 1] = new Node(false, buildings[i][1], buildings[i][2]);
        }
        Arrays.sort(nodes, new NodeComparator()); // 按照位置排序
        TreeMap<Integer, Integer> heightTimesMap = new TreeMap<>(); //某一个高度出现的次数
        TreeMap<Integer, Integer> xMaxHeightMap = new TreeMap<>();  //当前位置最大高度是多少
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i].isUp) {//加高度的操作
                if (!heightTimesMap.containsKey(nodes[i].h)) {//如果不含有此高度，则次数为1，否则次数加1
                    heightTimesMap.put(nodes[i].h, 1);
                } else {
                    heightTimesMap.put(nodes[i].h, heightTimesMap.get(nodes[i].h) + 1);
                }
            } else {//减高度的操作
                if (heightTimesMap.get(nodes[i].h) == 1) { //如果减完之后次数为0，则直接删除这条记录
                    heightTimesMap.remove(nodes[i].h);
                } else {
                    heightTimesMap.put(nodes[i].h, heightTimesMap.get(nodes[i].h) - 1);
                }
            }
            //跟踪记录每个位置最大高度的变化
            if (heightTimesMap.isEmpty()) {
                xMaxHeightMap.put(nodes[i].posi, 0);
            } else {
                xMaxHeightMap.put(nodes[i].posi, heightTimesMap.lastKey());
            }
        }
        //生成最后的轮廓线，只用 xMaxHeightMap 就可以建立出来
        List<List<Integer>> res = new ArrayList<>();
        int start = 0;
        int height = 0;
        for (Map.Entry<Integer, Integer> entry : xMaxHeightMap.entrySet()) {
            int curPosition = entry.getKey();    //当前位置
            int curMaxHeight = entry.getValue();  //当前最大高度
            if (height != curMaxHeight) {  //之前的高度不等于现在的最大高度，说明要开始产生轮廓线了；
                if (height != 0) {
                    List<Integer> newRecord = new ArrayList<>();
                    newRecord.add(start);
                    newRecord.add(curPosition);
                    newRecord.add(height);
                    res.add(newRecord);
                }
                start = curPosition;
                height = curMaxHeight;
            }
        }
        return res;
    }
}