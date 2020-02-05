package org.clay.chapter2;

/**
 * 旋转数组的最小数字
 * 旋转之后的数组实际上可以划分为两个排序的子数组，而且前面子数组的元素都大于或者等于后面子数组的元素，且最小的元素刚好是这两个子数组的分界线；
 * 二分：如果中间元素大于等于前指针，说明最小元素在中间元素的后面，如果中间元素小于等于后指针，说明最小元素在中间元素的前面，
 * 结束条件：前后指针距离为1
 */
public class Ex_02_MinValueOfSpinArray {


    public static Integer process(int[] arr){

        int left = 0;
        int right = arr.length-1;

        int resultIndex = left;

        while(arr[left] >= arr[right]){

            if(right - left == 1){
                resultIndex = right;
                break;
            }

            resultIndex = right - (right - left) / 2;

            if(arr[left] == arr[right] && arr[resultIndex] == arr[left]){
                return minInOrder(arr,left,right);
            }

            if(arr[resultIndex] >= arr[left]){
                left = resultIndex;
            }
            if(arr[resultIndex] <= arr[right]){
                right = resultIndex;
            }
        }

        return arr[resultIndex];
    }

    public static Integer minInOrder(int[] arr,int left,int right){
        int result = arr[left];

        for(int i = left+1; i <= right; i++){
            if(arr[i] < result){
                result = arr[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {

        //int[] arr = new int[]{3,4,5,1,2};
        int[] arr = new int[]{1,0,1,1,1};
        System.out.println(process(arr));
    }
}
