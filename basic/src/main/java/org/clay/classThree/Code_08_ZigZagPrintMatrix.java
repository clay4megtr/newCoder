package org.clay.classThree;

public class Code_08_ZigZagPrintMatrix {

    public static void printMatrixZigZag(int[][] matrix) {
        int aR = 0;
        int aC = 0;
        //右下角
        int bR = 0;
        int bC = 0;
        int endR = matrix.length - 1;       //结束行
        int endC = matrix[0].length - 1;    //结束列
        boolean fromUp = false;
        while (aR != endR + 1) {            //A点的行没有到右下角所在的行，就循环，因为A是先向右，再向下
            printLevel(matrix, aR, aC, bR, bC, fromUp);
            aR = aC == endC ? aR + 1 : aR;  //如果A点的列到了最后一列，就把A的行向下移动。
            aC = aC == endC ? aC : aC + 1;  //如果A点的列到了最后一列，A的列就不变了，否则，一直向右。
            bC = bR == endR ? bC + 1 : bC;  //如果B点的行到了最后一行，就向右，
            bR = bR == endR ? bR : bR + 1;
            fromUp = !fromUp;
        }
        System.out.println();
    }

    /**
     * 根据对角（两个点）
     * 按照对角线打印。
     */
    public static void printLevel(int[][] m, int tR, int tC, int dR, int dC,
                                  boolean f) {
        if (f) {//从上往下打印
            while (tR != dR + 1) {
                System.out.print(m[tR++][tC--] + " ");//行++，列--
            }
        } else {//从下往上打印
            while (dR != tR - 1) {
                System.out.print(m[dR--][dC++] + " ");//行--，列++
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        printMatrixZigZag(matrix);
    }
}
