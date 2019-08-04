package org.clay.classEight_Re;

public class All_Subsquences {

    public static void printAllSub(char[] words,int level,String res){
        if(level == words.length){
            System.out.println(res);
            return;
        }

        printAllSub(words,level+1,res);
        printAllSub(words,level+1,res+words[level]);
    }

    public static void main(String[] args) {
        String test = "abc";
        //printAllSubsquence(test);
        printAllSub(test.toCharArray(),0,"");
    }
}
