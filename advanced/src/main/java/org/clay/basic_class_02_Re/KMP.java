package org.clay.basic_class_02_Re;

public class KMP {



    /**
     * 求next数组
     */
    public static int[] getNextArray(char[] ms){

        int[] next = new int[ms.length];

        next[0] = -1;
        next[1] = 0;

        int pos = 2;
        int cn = 0;

        while(pos < next.length){
            if(ms[pos-1] == ms[cn]){
                next[pos++] = ++cn;
            }else if(cn > 0){
                cn = next[cn];
            }else{
                next[pos++] = 0;
            }
        }

        return next;
    }
}
