package org.clay.test3;

public class MaxValue {

    //从i位置开始，能够拿到的最大价值
    public static int maxValue(int[] w,int[] v, int bag,int cost,int i){

        if(cost > bag){
            return Integer.MIN_VALUE;
        }

        if(i == w.length){
            return 0;
        }

        int left_value = v[i] + maxValue(w,v,bag,cost+w[i],i+1);
        int right_value = maxValue(w,v,bag,cost,i+1);

        return Math.max(left_value,right_value);
    }

    public static void main(String[] args) {

        int[] w = new int[]{7,3};
        int[] v = new int[]{9,5};

        int max_value = maxValue(w,v,6,0,0);
        System.out.println(max_value);
    }
}
