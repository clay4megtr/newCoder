package org.clay.test1;

public class Test2Fen {

    public static boolean isTrue(int[] arr,int num){

        int left = 0;
        int right = arr.length-1;
        int mid = 0;

        while(left <= right){

            mid = (left + right) / 2;
            if(arr[mid] == num){
                return true;
            }else if(arr[mid] > num){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6};
        System.out.println(isTrue(arr,5));
    }
}
