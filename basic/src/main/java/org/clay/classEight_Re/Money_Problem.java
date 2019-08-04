package org.clay.classEight_Re;



public class Money_Problem {

    public static boolean process(int[] arr, int target, int level,int sum){
        if(level == arr.length){
            return target == sum;
        }

        return process(arr,target,level+1,sum) || process(arr,target,level+1,sum + arr[level]);
    }

    public static boolean process1(int[] arr,int target){

        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
        }

        if(target > sum){
            return false;
        }

        boolean[][] res = new boolean[arr.length+1][sum+1];

        for(int j = res[0].length-1; j >= 0; j--){  //最后一行
            if(j == target){
                res[res.length-1][j] = true;
            }else{
                res[res.length-1][j] = false;
            }
        }

        for(int i = res.length-2; i >= 0; i--){  //行数从倒数第二行往上
            for(int j = 0; j < res[0].length; j++){
                if(j + arr[i] >= res[0].length){
                    res[i][j] = res[i+1][j];
                }else{
                    res[i][j] = res[i+1][j] || res[i+1][j+arr[i]];
                }
            }
        }

        return res[0][0];
    }

    public static void main(String[] args) {
        int[] arr = { 1, 4, 8 };
        int aim = 12;
//		System.out.println(money1(arr, aim));
//		System.out.println(money2(arr, aim));
        //boolean res = process(arr,aim,0,0);
        boolean res = process1(arr,aim);
        System.out.println(res);
    }
}
