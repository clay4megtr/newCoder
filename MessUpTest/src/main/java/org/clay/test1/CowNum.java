package org.clay.test1;

public class CowNum {

    public static int getCowNum(int year){

        //假设第一年只有一头牛
        if(year == 1 || year ==2 || year == 3){
            return year;
        }

        return getCowNum(year-1) + getCowNum(year-3);
    }
}
