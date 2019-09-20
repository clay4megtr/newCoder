package org.clay.Book_Re_Other;

import java.util.ArrayList;
import java.util.List;

/**
 * 对n字典序排序
 */
public class LexicalOrder {

    //1,2,3,4,...11,12,13,....,n
    //1,10,100...
    public static List<Integer> dfsPrint(int n){

        if(n <= 0){
            throw new IllegalArgumentException("n must > 0");
        }

        List<Integer> res = new ArrayList<>();

        for(int i = 1; i <= 9; i++){
            res.add(i);
            helper(res,n,i);
        }

        return res;
    }

    public static void helper(List<Integer> res,int n,int tmp){

        tmp = tmp * 10;
        for(int i = 0; i <= 9; i++){
            int new_tmp = tmp + i;

            if(new_tmp < n){
                res.add(new_tmp);
                helper(res,n,new_tmp);
            }else{
                break;
            }
        }
    }


    public static void main(String[] args) {

        dfsPrint(115).stream().forEach(System.out::println);
    }
}
