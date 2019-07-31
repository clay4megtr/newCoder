package org.clay.test1;

public class PrintAllSequence {

    public static void printAll(char[] chars, int n, String res) {
        if (n == chars.length) {
            System.out.println(res);
        }else{
            printAll(chars, n + 1, res + chars[n]);
            printAll(chars, n + 1, res);
        }
    }

    public static void main(String[] args) {
        char[] chars = "abc".toCharArray();
        printAll(chars, 0, "");
    }
}
