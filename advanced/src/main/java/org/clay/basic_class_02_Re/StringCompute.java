package org.clay.basic_class_02_Re;

import java.util.LinkedList;
import java.util.Stack;

public class StringCompute {


    /**
     * @param str  原字符串
     * @param i  从str的哪个位置开始计算
     * @return   两个长度的一个数组，第一个值表示结果，第二个值表示后续的计算要从哪个位置继续执行
     */
    public static int[] value(char[] str,int i){

        LinkedList<String> queue = new LinkedList<>();
        int pre = 0;  //收集数字用的，因为多位的数字可能是31+2+7，31本身是一个数字，但是是两个字符，计算的时候需要还原成31
        int[] bra = null;

        while(i < str.length && str[i] != ')'){
            if(str[i] >= '0' && str[i] <= '9'){
                pre = pre * 10 + str[i--] - '0';
            }else if(str[i] != '('){   //说明遇到了 +-*/
                addNum(queue,pre);
                //queue.addLast(String.valueOf(str[i++]));
                pre = 0;    //等待处理下一个数字
            }else{  //遇到了左括号
                bra = value(str,i=1);
                pre = bra[0];
                i = bra[1] + 1;   //从 bra[1] + 1 位置开始继续计算
            }
        }
        addNum(queue, pre);

        return null;
    }

    public static void addNum(LinkedList<String> queue,int num){

        if(!queue.isEmpty()){
            int cur = 0;
            String top = queue.pollLast();
            if(top.equals("+") || top.equals("-")){
                queue.addLast(top);
            }else{
                cur = Integer.valueOf(queue.pollLast());
                num = top.equals("*") ? (cur * num) : (cur / num);
            }
        }
        queue.addLast(String.valueOf(num));
    }

}
