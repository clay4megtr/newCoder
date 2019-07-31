package org.clay.classThree;

public class Code_06_PrintMatrixSpiralOrder {

    public static void spiralOrderPrint(int[][] matrix) {
        //左上角
        int tR = 0;
        int tC = 0;
        //右下角
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;

        /**
         * 一圈一圈的打印，
         * 一圈打印完成之后，
         * 左上角向右下角移动一个位置，右下角向左上角移动一个位置。
         * 然后重复此过程
         * 直到有行或列冲突了，停止。
         */
        while (tR <= dR && tC <= dC) {
            printEdge(matrix, tR++, tC++, dR--, dC--);
        }
    }

    /**
     * 打印一圈
     * @param m
     * @param tR    左上角
     * @param tC    右上角
     * @param dR    左下角
     * @param dC    右下角
     */
    public static void printEdge(int[][] m, int tR, int tC, int dR, int dC) {
        if (tR == dR) {                             //一行
            for (int i = tC; i <= dC; i++) {
                System.out.print(m[tR][i] + " ");
            }
        } else if (tC == dC) {                      //一列
            for (int i = tR; i <= dR; i++) {
                System.out.print(m[i][tC] + " ");
            }
        } else {
            int curC = tC;
            int curR = tR;
            while (curC != dC) {                   //上
                System.out.print(m[tR][curC] + " ");
                curC++;
            }
            while (curR != dR) {                    //右
                System.out.print(m[curR][dC] + " ");
                curR++;
            }
            while (curC != tC) {                    //下
                System.out.print(m[dR][curC] + " ");
                curC--;
            }
            while (curR != tR) {                    //左
                System.out.print(m[curR][tC] + " ");
                curR--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        spiralOrderPrint(matrix);

    }

}
