package org.clay.classThree_Re_1;

/**
 *   把一个矩阵调整成旋转90度的样子
 */
public class RotateMatrix {

    public static void rotate(int[][] matrix){

        //左上角
        int lR = 0;
        int lC = 0;
        //右下角
        int rR = matrix.length - 1;
        int rC = matrix.length - 1;

        while(lR < rR && lC < rC){
            print(matrix,lR++,lC++,rR--,rC--);
        }
    }

    public static void print(int[][] arr, int lR, int lC, int rR, int rC){

        int times = rC - lC;

        int tmp = 0;
        //其实这里的过程就是一个复杂的t=a,a=b,b=t 的过程
        for(int i = 0; i < times; i++){
            int temp = arr[lR][lC + i];
            arr[lR][lC + i] = arr[rR - i][lC];//上面一行被左边一列替换掉
            arr[rR - i][lC] = arr[rR][rC - i];//左边一列被下面一行替换掉
            arr[rR][rC - i] = arr[lR + i][rC];//下面一行被右面一列替换掉
            arr[lR + i][rC] = temp;           //右面一列被上面一行替换掉
        }

    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        printMatrix(matrix);
        rotate(matrix);
        System.out.println("=========");
        printMatrix(matrix);
    }
}
