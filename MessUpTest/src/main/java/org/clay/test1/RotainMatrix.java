package org.clay.test1;

public class RotainMatrix {

    public static void ratainMatrix(int[][] matrix){

        //left top
        int x = 0;
        int y = 0;

        //right down
        int a = matrix.length-1;
        int b = matrix[0].length-1;

        while(x <= a && y <= b){

            ratain(matrix,x++,y++,a--,b--);
        }
    }

    private static void ratain(int[][] matrix, int x, int y, int a, int b) {

        int times = b - y;

        for(int i = 0; i < times; i++){

            int tmp = matrix[x][y+i];
            matrix[x][y+i] = matrix[a-i][y];
            matrix[a-i][y] = matrix[a][b-i];
            matrix[a][b-i] = matrix[x+i][b];
            matrix[x+i][b] = tmp;
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
        ratainMatrix(matrix);
        System.out.println("=========");
        printMatrix(matrix);

    }
}
