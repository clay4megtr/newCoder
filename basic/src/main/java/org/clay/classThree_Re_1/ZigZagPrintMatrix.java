package org.clay.classThree_Re_1;

public class ZigZagPrintMatrix {

    public static void printMatrixZigZag(int[][] matrix){

        int aR = 0;
        int aC = 0;

        int bR = 0;
        int bC = 0;

        int endR = matrix.length-1;      //结束行
        int endC = matrix[0].length-1;   //结束列

        boolean fromUp = false;
        while(aR <= endR){
            print(matrix,aR,aC,bR,bC,fromUp);
            aR = (aC == endC) ? aR + 1 : aR;
            aC = (aC == endC) ? aC : aC + 1;
            bC = (bR == endR) ? bC + 1 : bC;
            bR = (bR == endR) ? bR : bR + 1;
            fromUp = !fromUp;
        }
        System.out.println();
    }

    public static void print(int[][] matrix, int aR, int aC, int bR, int bC, boolean f){

        if(f){  //从上往下打印
            while(aR <= bR && aC >= bC){
                System.out.println(matrix[aR++][aC--]);
            }
        }else{  //从下网上打印
            while(bR >= aR && bC <= aC){
                System.out.println(matrix[bR--][bC++]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        printMatrixZigZag(matrix);
    }
}