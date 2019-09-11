package org.clay.test3;

public class AllSequence {


    public static void printAllSequence(String str,int level,int cur_level,String res){

        if(cur_level == level){
            System.out.println(res);
        }else{
            printAllSequence(str,level,cur_level+1,res + str.toCharArray()[cur_level]);
            printAllSequence(str,level,cur_level+1,res);
        }
    }

    public static void main(String[] args) {

        String str = "abc";

        printAllSequence(str,str.length(),0,"");
    }
}
