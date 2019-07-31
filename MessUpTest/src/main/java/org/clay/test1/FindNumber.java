package org.clay.test1;

public class FindNumber {

    public static boolean find(int[][] matrix,int num){

        int x = 0;
        int y = matrix[0].length;

        while(x < matrix.length && y >= 0){

            if(num < matrix[x][y]){
                y--;
            }else if(num > matrix[x][y]){
                x++;
            }else{
                return true;
            }
        }
        return false;
    }
}
