package org.clay.test1;

public class IsGetAim {

    public static boolean canGetAim(int[] arr,int aim,int i,int res){

        if(i == arr.length){
            return res == aim;
        }

        return canGetAim(arr,aim,i+1,res + arr[i]) || canGetAim(arr,aim,i+1,arr[i]);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        System.out.println(canGetAim(arr,7,0,0));
    }
}
