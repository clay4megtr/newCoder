package org.clay.classFive_Re;

public class Islands {


    public static int getNumber(int[][] matrix){

        int res = 0;
        int row = matrix.length;
        int column = matrix[0].length;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                if(matrix[i][j] == 1){
                    res += 1;
                    infect(matrix,i,j,row,column);
                }
            }
        }
        return res;
    }

    /**
     * 感染
     */
    public static void infect(int[][] matrix, int i,int j,int r,int c){
        if(i < 0 || i > r || j < 0 || j > c || matrix[i][j] != 1){
            return;
        }
        matrix[i][j] = 2;
        infect(matrix,i-1,j,r,c);  //up
        infect(matrix,i+1,j,r,c);  //down
        infect(matrix,i,j-1,r,c);  //left
        infect(matrix,i,j+1,r,c);
    }
}