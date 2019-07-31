package org.clay.classThree;

public class Code_05_RotateMatrix {

    public static void rotate(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;

        while (tR < dR) {
            rotateEdge(matrix, tR++, tC++, dR--, dC--);
        }
    }

    /**
     * 一定是长方形
     * 根据两个对角的值进行旋转，每次旋转一个圈。
     * @param m
     * @param tR    左上角行号
     * @param tC    左上角列号
     * @param dR    右下角行号
     * @param dC    右下角列号
     */
    public static void rotateEdge(int[][] m, int tR, int tC, int dR, int dC) {
        int times = dC - tC;//列号相减，也就求出了每行或者每列要有多少个数字进行旋转，也就是下面的for循环要执行的次数。
        int tmp = 0;
        //每一个要旋转的数字，
        // 4个点之间进行互换位置。
        for (int i = 0; i != times; i++) {
            tmp = m[tR][tC + i];//首先记下第一个要换的数字，因为要被覆盖。
            m[tR][tC + i] = m[dR - i][tC];
            m[dR - i][tC] = m[dR][dC - i];
            m[dR][dC - i] = m[tR + i][dC];
            m[tR + i][dC] = tmp;
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
