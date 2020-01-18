package org.clay.Book_Re_Other;

/**
 * 买卖股票的最佳时机
 */
public class MaxProfilt {


    /**
     * 条件：没有交易次数的限制，但是某一时刻只能处于一次交易中，也就是说必须卖了才能买
     * [7,1,5,3,6,4]
     * res: 7
     */
    public static int getMaxProfit2(int[] prices){

        int maxProfit = 0;
        int valley = prices[0];
        int peak = prices[0];
        int i = 0;

        while(i < prices.length-1){

            //** 要注意先找谷值再找峰值，因为先买才能卖，才能产生价值；
            while(i < prices.length-1 && prices[i] > prices[i+1]){
                i++;
            }
            valley = prices[i];

            while(i < prices.length-1 && prices[i] < prices[i+1]){
                i++;
            }
            peak = prices[i];

            maxProfit += peak - valley;
        }

        return maxProfit;
    }

    //上面的过程可以简化
    public static int getMaxProfit3(int[] prices){

        int maxProfit = 0;

        for(int i = 1; i< prices.length; i++){
            if(prices[i] > prices[i-1]){
                maxProfit += prices[i] - prices[i-1];
            }
        }

        return maxProfit;
    }



    /**
     * 条件：只能交易一次
     * [7,1,5,3,6,4]
     * res: 5
     */
    public static int getMaxProfit(int[] arr){

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] < minPrice){
                minPrice = arr[i];
            }else if(arr[i] - minPrice > maxProfit){
                maxProfit = arr[i] - minPrice;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{7,1,5,3,6,4};
        int[] arr1 = new int[]{7,6,4,3,1};
        System.out.println(getMaxProfit2(arr1));
    }
}
