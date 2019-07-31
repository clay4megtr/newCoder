package org.clay.test1;

public class MinPath {

    /**
     * 从(i,j) 位置 到 右下角的最短路径
     */
    public static int getPath(int[][] matrix,int i,int j){

        if(i == matrix.length-1 && j == matrix[0].length-1){
            return matrix[i][j];
        }
        if(i == matrix.length-1){
            return getPath(matrix,i,j+1) + matrix[i][j];
        }
        if(j == matrix[0].length-1){
            return getPath(matrix,i+1,j) + matrix[i][j];
        }
        return Math.min(getPath(matrix,i,j+1),getPath(matrix,i+1,j)) + matrix[i][j];
    }

    public static int getPath1(int[][] matrix){

        int[][] res = new int[matrix.length][matrix[0].length];

        res[matrix.length-1][matrix[0].length-1] = matrix[matrix.length-1][matrix[0].length-1];

        for(int j = matrix[0].length-2; j >= 0; j--){
            res[matrix.length-1][j] = res[matrix.length-1][j+1] + matrix[matrix.length-1][j];
        }

        for(int i = matrix.length-2; i >= 0; i--){
            res[i][matrix[0].length-1] = res[i+1][matrix[0].length-1] + matrix[i][matrix[0].length-1];
        }

        for(int i = matrix.length-2; i >= 0; i--){
            for(int j = matrix[0].length-2; j >= 0; j--){
                res[i][j] = matrix[i][j] + Math.min(res[i][j+1],res[i+1][j]);
            }
        }

        return res[0][0];
    }

    public static void main(String[] args) {
        int[][] m = {{1, 3, 5, 9}, {8, 1, 3, 4}, {5, 0, 6, 1}, {8, 8, 4, 0}};
        System.out.println(getPath(m,0,0));
        System.out.println(getPath1(m));
    }
}