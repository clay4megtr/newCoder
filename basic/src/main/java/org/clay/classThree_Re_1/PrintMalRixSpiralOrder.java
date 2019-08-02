package org.clay.classThree_Re_1;

public class PrintMalRixSpiralOrder {

    /**
     * 转圈打印矩阵
     */
    public static void printNum(int[][] matrix) {

        //左上角
        int lR = 0;
        int lC = 0;

        //右下角
        int rR = matrix.length-1;
        int rC = matrix[0].length-1;

        while(lR < rR){
            print(matrix,lR++,lC++,rR--,rC--);
        }
    }

    public static void print(int[][] matrix, int lR, int lC, int rR, int rC) {

        int oldlC = lC;
        int oldlR = lR;

        //打印上边的行
        while(rC > lC){
            System.out.println(matrix[lR][lC++]);  //1,2,3     lC
        }

        //打印右边的列
        while(lR < rR){
            System.out.println(matrix[lR++][rC]); //4,8,12      lR
        }

        //打印下边的行
        while(rC > oldlC){
            System.out.println(matrix[rR][rC--]); //16,15,14
        }

        //打印左边的列
        while(rR > oldlR){
            System.out.println(matrix[rR--][rC]);  //13,9,5
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        printNum(matrix);

    }
}
