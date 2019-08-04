package org.clay.classEight_Re;

public class Print_All_Permutations {

    public static void printAllPermutations1(String str) {
        char[] chs = str.toCharArray();
        process(chs, 0);
    }

    public static void process(char[] words,int level){

        if(level == words.length-1){
            System.out.println(words);
        }

        for(int i = level; i < words.length; i++){
            swap(words,i,level);
            process(words,level+1);
            swap(words,i,level);
        }
    }

    public static void swap(char[] words,int a,int b){
        char t = words[a];
        words[a] = words[b];
        words[b] = t;
    }

    public static void main(String[] args) {
        String test1 = "abc";
        printAllPermutations1(test1);
    }
}
