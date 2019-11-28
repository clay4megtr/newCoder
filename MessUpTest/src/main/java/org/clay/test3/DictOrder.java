package org.clay.test3;

import java.util.ArrayList;
import java.util.List;

public class DictOrder {


    //1,2,3,4,....13
    //1,10,11,12,13,2,3,4,....9
    public static List<Integer> test(int n){

        List<Integer> res = new ArrayList<>();
        for(int i = 1; i <= 9; i++){
            res.add(i);
            test2(res,n,i);
        }

        return res;
    }

    public static void test2(List<Integer> res,int n,int tmp){

        tmp = tmp * 10;
        for(int i = 0; i < n; i++){
            int newtmp = tmp + i;
            if(newtmp > n){
                break;
            }else{
                res.add(newtmp);
                test2(res,n,newtmp);
            }
        }
    }

    public static void main(String[] args) {

        test(13).stream().forEach(System.out::println);
    }
}
