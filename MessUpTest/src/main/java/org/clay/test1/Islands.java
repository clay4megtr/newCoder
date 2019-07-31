package org.clay.test1;

public class Islands {

    public static int countIslands(int[][] m){

        if(m == null || m.length == 0){
            return 0;
        }
        int N = m.length;
        int M = m[0].length;
        int res = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(m[i][j] == 1){
                    res++;
                    inject(m,i,j,N,M);
                }
            }
        }

        return res;
    }

    private static void inject(int[][] m, int i, int j, int N, int M) {

        //base case
        if( i >= N || j >= M || i < 0 || j < 0 || m[i][j] != 1){
            return;
        }
        m[i][j] = 2;
        inject(m,--i,j,N,M);  //up
        inject(m,++i,j,N,M);  //down
        inject(m,i,--j,N,M);  //left
        inject(m,i,++j,N,M);  //right
    }

    public static void main(String[] args) {
        int[][] m1 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 0, 1, 1, 1, 0 },
                { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
                { 0, 1, 1, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
        System.out.println(countIslands(m1));

        int[][] m2 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 1, 1, 1, 1, 0 },
                { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
                { 0, 1, 1, 0, 0, 0, 1, 1, 0 },
                { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
        System.out.println(countIslands(m2));
    }
}
