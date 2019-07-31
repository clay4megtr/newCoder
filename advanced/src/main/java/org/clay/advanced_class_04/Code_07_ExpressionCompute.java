package org.clay.advanced_class_04;

import java.util.LinkedList;

public class Code_07_ExpressionCompute {

    public static int getValue(String str) {
        return value(str.toCharArray(), 0)[0];
    }

    /**
     * 递归函数
     * @param str
     * @param i index 从哪个位置开始算；
     * @return 两个值，第一个值代表子过程的返回结果，第二个是父过程要从哪个位置继续计算
     */
    public static int[] value(char[] str, int i) {
        LinkedList<String> que = new LinkedList<String>();
        int pre = 0; //收集数字用的，因为多位的数字可能是31+2+7，31本身是一个数字，但是是两个字符，计算的时候需要还原成31
        int[] bra = null;
        while (i < str.length && str[i] != ')') {
            if (str[i] >= '0' && str[i] <= '9') {  //如果遇到的一直是数字，就一直累加上，计算出原本的数字31；而不是3
                pre = pre * 10 + str[i++] - '0';
            } else if (str[i] != '(') { //遇到了运算符号 +-*/
                addNum(que, pre);
                que.addLast(String.valueOf(str[i++]));  //收集到栈中；
                pre = 0;  //等待处理下一个数字
            } else {  //遇到了  (
                bra = value(str, i + 1);  //递归
                pre = bra[0];
                i = bra[1] + 1; //从 bra[1] + 1 位置开始继续计算
            }
        }
        addNum(que, pre);
        return new int[]{getNum(que), i};
    }

    public static void addNum(LinkedList<String> que, int num) {
        if (!que.isEmpty()) {
            int cur = 0;
            String top = que.pollLast();
            if (top.equals("+") || top.equals("-")) {
                que.addLast(top);
            } else {
                cur = Integer.valueOf(que.pollLast());
                num = top.equals("*") ? (cur * num) : (cur / num);
            }
        }
        que.addLast(String.valueOf(num));
    }

    public static int getNum(LinkedList<String> que) {
        int res = 0;
        boolean add = true;
        String cur = null;
        int num = 0;
        while (!que.isEmpty()) {
            cur = que.pollFirst();
            if (cur.equals("+")) {
                add = true;
            } else if (cur.equals("-")) {
                add = false;
            } else {
                num = Integer.valueOf(cur);
                res += add ? num : (-num);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String exp = "48*((70-65)-43)+8*1";
        System.out.println(getValue(exp));

        exp = "4*(6+78)+53-9/2+45*8";
        System.out.println(getValue(exp));

        exp = "10-5*3";
        System.out.println(getValue(exp));

        exp = "-3*4";
        System.out.println(getValue(exp));

        exp = "3+1*4";
        System.out.println(getValue(exp));
    }
}
