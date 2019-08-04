package org.clay.classEight_Re;

public class MinPath {

    /**
     * 从(i,j) 出发 到 右下角 的最短路径和
     */
    public static int walk(int[][] matrix,int i,int j){

        if(i == matrix.length-1 && j == matrix[0].length-1){
            return matrix[i][j];
        }

        if(i == matrix.length-1){
            return matrix[i][j] + walk(matrix,i,j+1);
        }

        if(j == matrix[0].length-1){
            return matrix[i][j] + walk(matrix,i+1,j);
        }

        return matrix[i][j] + Math.min(walk(matrix,i,j+1),walk(matrix,i+1,j));
    }

    public static int walkDp(int[][] matrix){

        int[][] res = new int[matrix.length][matrix[0].length];

        res[matrix.length-1][matrix[0].length-1] = matrix[matrix.length-1][matrix[0].length-1];  //右下角的值

        for(int i = matrix.length-2; i >= 0; i--){ //最后一列
            res[i][res[0].length-1] = res[i+1][res[0].length-1] + matrix[i][res[0].length-1];
        }

        for(int j = matrix[0].length-2; j >= 0; j--){
            res[matrix.length-1][j] = res[matrix.length-1][j+1] + matrix[res.length-1][j];
        }

        for(int i = matrix.length-2; i >= 0; i--){
            for(int j = matrix[0].length-2; j >= 0; j--){
                res[i][j] = matrix[i][j] + Math.min(res[i+1][j],res[i][j+1]);
            }
        }

        return res[0][0];
    }

    public static void main(String[] args) {
        int[][] m = {{1, 3, 5, 9}, {8, 1, 3, 4}, {5, 0, 6, 1}, {8, 8, 4, 0}};
        System.out.println(walk(m,0,0));
        System.out.println(walkDp(m));

    }
}
