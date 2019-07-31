package org.clay.test1;

public class ForEachArray {

    public static boolean isTrue(String str1,String str2){

        if(str1.length() != str2.length()){
            return false;
        }

        String res = str1 + str1;
        return res.contains(str2);
    }

    public static void main(String[] args) {

        String str1 = "abc";
        String str2 = "bca";

        System.out.println(isTrue(str1,str2));
    }
}
