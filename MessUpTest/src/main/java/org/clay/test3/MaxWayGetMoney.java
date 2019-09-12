package org.clay.test3;

public class MaxWayGetMoney {

    /**
     * @param arr  钱的种类，每种面值的货币可以使用任意张
     * @param aim  目标值
     * @param index  从哪个位置的货币开始用
     * @return    总共的方法数
     */
    public static int ways(int[] arr,int aim,int index){

        int res = 0;
        if(index == arr.length){
            return aim == 0 ? 1 : 0;
        }

        for(int i = 0; i * arr[index] <= aim; i++){
            res += ways(arr,aim-(i * arr[index]),index+1);
        }

        return res;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{5,10,25,1};
        System.out.println(ways(arr,15,0));
    }
}
