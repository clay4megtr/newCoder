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
        int rR = matrix.length-1;
        int rC = matrix[0].length-1;

        while(lR < rR){
            print(matrix,lR++,lC++,rR--,rC--);
        }
    }

    public static void print(int[][] matrix, int lR, int lC, int rR, int rC){

        int times = rC - lC;
        for(int i = 0; i < times; i++){
            int tmp = matrix[lR][lR+i];
            matrix[lR][lR+i] = matrix[rR-i][lC];
            matrix[rR-i][lC] = matrix[rR][rC-i];
            matrix[rR][rC-i] = matrix[lR+i][rC];
            matrix[lR+i][rC] = tmp;
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