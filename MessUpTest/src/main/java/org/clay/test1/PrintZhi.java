package org.clay.test1;


public class PrintZhi {

    public static void printMatrixZigZag(int[][] matrix){

        //A
        int x = 0;
        int y = 0;

        //B
        int a = 0;
        int b = 0;

        boolean flag = true;

        while((x == 0 && y == 0) | (x != a && y != b)){

            printX(matrix,x,y,a,b,flag);
            if(y == matrix[0].length-1){
                x++;
            }else{
                y++;
            }

            if(a == matrix.length-1){
                b++;
            }else{
                a++;
            }

            flag = flag ? false : true;
        }
    }

    private static void printX(int[][] matrix,int x, int y, int a, int b,boolean flag) {

        if(flag){ // true: from top to down
            while(x <= a && y >= b){
                System.out.println(matrix[x][y]);
                x++;
                y--;
            }
        }else{
            while(a >= x && b <= y){
                System.out.println(matrix[a][b]);
                a--;
                b++;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        printMatrixZigZag(matrix);
    }
}
