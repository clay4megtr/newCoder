package org.clay.classEight_Re;

public class All_Subsquences {

    public static void printAllSquence(String str,int level,String res){

        if(level == str.length()){
            System.out.println(res);
            return;
        }
        printAllSquence(str,level+1,res);
        printAllSquence(str,level+1,res + str.toCharArray()[level]);
    }

    public static void main(String[] args) {
        String test = "abc";
        //printAllSubsquence(test);
        printAllSquence(test,0,"");
    }
}
