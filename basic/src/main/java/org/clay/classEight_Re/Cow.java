package org.clay.classEight_Re;

public class Cow {

    public static int getCowNum(int n){

        if(n < 0){
            return 0;
        }
        if(n == 1 || n == 2 || n==3){
            return n;
        }
        return getCowNum(n-1) + getCowNum(n-3);
    }
}
