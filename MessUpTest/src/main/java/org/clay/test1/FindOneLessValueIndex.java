package org.clay.test1;

public class FindOneLessValueIndex {

    public static int getIndex(int[] arr){

        if(arr.length == 1){
            return 0;
        }
        if(arr[0] < arr[1]){
            return 0;
        }
        if(arr[arr.length-1] < arr[arr.length-2]){
            return arr.length-1;
        }
        int left = 1;
        int right = arr.length-2;
        int mid = 0;

        while(left <= right){

            System.out.println("left:" + left + "----right:" + right);

            mid = (left + right) / 2;
            if(arr[mid] > arr[mid-1]){
                right = mid-1;
                System.out.println("right:" + right);
            }else if(arr[mid] > arr[mid+1]){
                left = mid+1;
                System.out.println("left:" + left);

            }else{
                System.out.println("return -> " + mid);
                return mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 2, 1, 2, 3, 2, 4,6 };
        int index = getIndex(arr);
        System.out.println("index: " + index + ", value: " + arr[index]);

    }
}
