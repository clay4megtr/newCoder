package org.clay.test1;

public class PrintMatrix {

    public static void spiralOrderPrint(int[][] matrix){

        //left top
        int x = 0;
        int y = 0;

        //right down
        int a = matrix.length-1;
        int b = matrix[0].length-1;

        while(x <= a && y <= b){

            print(matrix,x++,y++,a--,b--);
        }
    }

    private static void print(int[][] matrix,int x, int y, int a, int b) {

        if(x == a){  //hang
            for(int i = y; i <= b; i++){
                System.out.println(matrix[x][i]);
            }

        }else if(y == b){  //lie
            for(int i = x; i <= a; i++){
                System.out.println(matrix[i][y]);
            }

        }else{
            for(int i = y; i <= b; i++){
                System.out.println(matrix[x][i]);
            }
            for(int i = x+1; i <= a; i++){
                System.out.println(matrix[i][b]);
            }
            for(int i = b-1; i >= y; i--){
                System.out.println(matrix[a][i]);
            }
            for(int i = a-1; i >= x+1; i--){
                System.out.println(matrix[i][y]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        spiralOrderPrint(matrix);
    }
}
