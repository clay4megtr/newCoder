package org.clay.classEight;


public class Code_07_MinPath {

    public static int minPath1(int[][] matrix) {
        return process1(matrix, matrix.length - 1, matrix[0].length - 1);
    }

    /**
     * 从(i,j) 出发，到达最右下角位置，最短路径和是多少？
     * @param matrix：
     * @param i：行
     * @param j：列
     * @return
     */
    public static int process1(int[][] matrix, int i, int j) {
        int res = matrix[i][j];
        if (i == 0 && j == 0) {
            return res;
        }
        if (i == 0 && j != 0) {
            return res + process1(matrix, i, j - 1);
        }
        if (i != 0 && j == 0) {
            return res + process1(matrix, i - 1, j);
        }
        return res + Math.min(process1(matrix, i, j - 1), process1(matrix, i - 1, j));
    }

    public static int minPath2(int[][] m) {
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
            return 0;
        }
        int row = m.length;
        int col = m[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = m[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + m[i][0];
        }
        for (int j = 1; j < col; j++) {
            dp[0][j] = dp[0][j - 1] + m[0][j];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + m[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }

    // for test
    public static int[][] generateRandomMatrix(int rowSize, int colSize) {
        if (rowSize < 0 || colSize < 0) {
            return null;
        }
        int[][] result = new int[rowSize][colSize];
        for (int i = 0; i != result.length; i++) {
            for (int j = 0; j != result[0].length; j++) {
                result[i][j] = (int) (Math.random() * 10);
            }
        }
        return result;
    }


    /**
     * 从(i,j)出发，到达最右下角位置，最短路径和是多少？
     * 暴力递归的方式
     * 缺点：会有很多的重复计算。
     * @param matrix：
     * @param i：行
     * @param j：列
     * @return
     *
     * 无后效性问题：
     * 只要状态的参数定了，返回值一定确定。
     * 有后效性问题：
     * 汉诺塔问题：要求就是打印所有的步骤，之前做出的选择，必然会影响着解，所以是有后效性的。
     *
     * 这里(i,j)确定了，那么解就确定了。
     * 那么所有的 (i,j) 的返回结果就会出现在一张二维表里。
     *
     * 高度套路：
     * 最重要的：写出尝试版本
     * 然后分析可变参数，哪几个可变参数可以代表返回值的状态，可变参数是几维的，就是一张几维表，
     * 然后看看终止状态是哪一个，在表中点出来，然后回到base case中，把完全不依赖的位置的值，设置好，
     * 然后一个普遍位置，看看它需要哪些位置，逆着回去，就是填表的顺序。
     */
    public static int walk(int[][] matrix, int i, int j) {
        if(i == matrix.length && j == matrix[0].length){
            return matrix[i][j];
        }

        if(i == matrix.length - 1){ //如果到达最后一行，那么只能向右走。
            return matrix[i][j] + walk(matrix,i,j+1);
        }
        if(j == matrix[0].length){//如果到达最后一列了，那么只能向下走。
            return matrix[i][j] + walk(matrix,i+1,j);
        }

        int right = walk(matrix,i,j+1);//right-> 右边位置到右下角的最短路径和。
        int down = walk(matrix,i+1,j); //left-> 下边位置到右下角的最短路径和。

        return matrix[i][j] + Math.min(right,down);
    }


    public static void main(String[] args) {
        int[][] m = {{1, 3, 5, 9}, {8, 1, 3, 4}, {5, 0, 6, 1}, {8, 8, 4, 0}};
        System.out.println(minPath1(m));
        System.out.println(minPath2(m));

        m = generateRandomMatrix(6, 7);
        System.out.println(minPath1(m));
        System.out.println(minPath2(m));
    }
}
