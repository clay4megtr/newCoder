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
        int rR = matrix.length - 1;
        int rC = matrix[0].length - 1;

        while(lR < rR && lC < rC){
            print(matrix,lR++,lC++,rR--,rC--);
        }
    }

    public static void print(int[][] arr, int lR, int lC, int rR, int rC) {

        if (lR == rR) {                             //一行
            for (int i = lC; i <= rC; i++) {
                System.out.print(arr[lR][i] + " ");
            }
        } else if (lC == rC) {                      //一列
            for (int i = lR; i <= rR; i++) {
                System.out.print(arr[i][lC] + " ");
            }
        } else {

            int lCtem = lC;
            int lRTem = lR;

            //先打印上行
            while (lC < rC) {
                System.out.println(arr[lR][lC]);
                lC++;
            }

            //打印右列
            while (lR < rR) {
                System.out.println(arr[lR][rC]);
                lR++;
            }

            //打印下行
            while (rC > lCtem) {
                System.out.println(arr[rR][rC]);
                rC--;
            }

            //打印左列
            while (rR > lRTem) {
                System.out.println(arr[rR][lCtem]);
                rR--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        printNum(matrix);

    }
}
