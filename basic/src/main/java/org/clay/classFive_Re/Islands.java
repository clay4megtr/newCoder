package org.clay.classFive_Re;

public class Islands {


    public static int getNumber(int[][] matrix){

        int res = 0;
        int r = matrix.length;
        int c = matrix[0].length;

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(matrix[i][j] == 1){
                    res++;
                    infect(matrix,i,j,r,c);
                }
            }
        }

        return res;
    }

    /**
     * 感染
     */
    public static void infect(int[][] matrix, int i,int j,int r,int c){
        if(i >= r || j >= c || i < 0 || j < 0 || matrix[i][j] != 1){
            return;
        }
        matrix[i][j] = 2;

        infect(matrix,i+1,j,r,c);
        infect(matrix,i-1,j,r,c);
        infect(matrix,i,j+1,r,c);
        infect(matrix,i,j-1,r,c);
    }
}