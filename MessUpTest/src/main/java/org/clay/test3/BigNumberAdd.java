package org.clay.test3;

//关键点：ASIC 值相减
public class BigNumberAdd {

    public static String add(String aStr,String bStr){

        int aLen = aStr.length();
        int bLen = bStr.length();

        int maxLen = Math.max(aLen,bLen);
        int minLen = Math.min(aLen,bLen);

        String a = aStr.length() > bStr.length() ? aStr: bStr;
        String b = a.equals(bStr) ? aStr : bStr;

        String aRe = new StringBuilder(a).reverse().toString();  //长
        String bRe = new StringBuilder(b).reverse().toString();  //短

        StringBuilder res = new StringBuilder();

        int carry = 0;
        int i = 0;

        for(; i < minLen; i++){
            int num = aRe.charAt(i) + bRe.charAt(i) - 2 * '0' + carry;
            res.append(num % 10);
            carry = num / 10;
        }

        for(; i < maxLen; i++){
            int num = aRe.charAt(i) - '0' + carry;
            res.append(num % 10);
            carry = num / 10;
        }
        if(carry != 0){
            res.append(carry);
        }

        return String.valueOf(res.reverse());
    }

    public static void main(String[] args) {

        String a = "9560";
        String b = "1234";

        System.out.println(add(a,b));
    }



}
