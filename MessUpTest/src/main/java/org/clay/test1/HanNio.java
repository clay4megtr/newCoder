package org.clay.test1;

public class HanNio {

    public static void han(int N){
        hannoD(N,"from","to","help");
    }


    public static void hannoD(int N,String from,String to, String help){
        if(N == 1){
            System.out.println("move 1 from " + from + " to " + to);
        }else {
            hannoD(N - 1, from, help, to);
            System.out.println("move " + N + " from " + from + " to " + to);
            hannoD(N - 1, help, to, from);
        }
    }

    public static void main(String[] args) {
        han(3);
    }
}
