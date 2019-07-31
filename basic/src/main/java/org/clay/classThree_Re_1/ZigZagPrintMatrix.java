package org.clay.classThree_Re_1;

public class ZigZagPrintMatrix {

    public static void printMatrixZigZag(int[][] matrix){

        int aR = 0;
        int aC = 0;

        int bR = 0;
        int bC = 0;     //B往下，往右

        int down = matrix.length - 1;
        int right = matrix[0].length - 1;

        boolean f = false;

        while(aR <= down && bC <= right){

            print(matrix,aR,aC,bR,bC,f);

            if(aC < right){     //A往右，往下, 注意：这里等于right的时候，就不能加了。
                aC++;
            }else {
                aR++;
            }


            if(bR < down){
                bR++;
            }else{
                bC++;
            }

            f = !f;
        }
    }

    public static void print(int[][] arr, int aR, int aC, int bR, int bC, boolean f){

        if(f){              //从右上到左下
            while(aR <= bR && aC >= bC){
                System.out.println(arr[aR++][aC--]);
            }
        }else{
            while(bR >= aR && bC <= aC){
                System.out.println(arr[bR--][bC++]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        printMatrixZigZag(matrix);
    }
}

