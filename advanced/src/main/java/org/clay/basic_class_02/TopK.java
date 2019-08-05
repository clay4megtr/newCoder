package org.clay.basic_class_02;

public class TopK {

    public static int[] partition(int[] arr,int left,int right,int target){

        int less = left-1;
        int more = right+1;
        int cur = left;

        while(cur < more){
            if(arr[cur] > target){
                swap(arr,cur,--more);
            }else if(arr[cur] < target){
                swap(arr,cur++,++less);
            }else{
                cur++;
            }
        }
        return new int[]{less,more};
    }

    public static void swap(int[] arr,int a,int b){
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }


    public static int getTopK(int[] arr,int k,int left,int right){

        int[] par = partition(arr,left,right,arr[right]);

        if(par[0] < k && k < par[1]){
            return arr[k];
        }else if(k <= par[0]){
            return getTopK(arr,k,left,par[0]);
        }else{
            return getTopK(arr,k,par[1],right);
        }
    }

    public static void main(String[] args) {

        int[] arr = new int[]{3,6,4,5,2,1};

        //System.out.println(partition(arr,0,arr.length-1,3)[0]);
        System.out.println(getTopK(arr,5,0,arr.length-1));
    }
}
