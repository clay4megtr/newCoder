package org.clay.test4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 按照字典序排序
 */
public class DictOrder {


    public static List<Integer> process(int n){

        List<Integer> res = new ArrayList<>();

        for(int i = 1; i <= 9; i++){
            res.add(i);
            helper(i,res,n);
        }

        return res;
    }

    public static void helper(int pre,List<Integer> res,int n){

        pre = pre * 10;
        for(int i = 0; i <= 9; i++){
            int newPre = pre + i;
            if(pre < n){
                res.add(newPre);
                helper(newPre,res,n);
            }else if(newPre == n){
                res.add(newPre);
            }else{
                break;
            }
        }
    }

    public static void main(String[] args) {

        process(109).stream().forEach(System.out::println);
    }
}