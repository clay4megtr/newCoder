package org.clay.Book_Re_String;


/**
 * 1. 判断整体是否是有效的括号字符串
 * 2. 给定一个括号字符串，返回最长的有效括号字符串的长度
 * (()())    6
 * ())       2
 * ()(()()(  4   ()()
 */
public class KuoHao {

    public boolean isVaild(String str){

        if(str.length() == 0 || str == null){
            return false;
        }

        char[] chars = str.toCharArray();

        int status = 0;

        for(int i = 0; i < chars.length; i++){
            if(chars[i] != ')' && chars[i] != '('){
                return false;
            }
            if(chars[i] == ')' && --status < 0){
                return false;
            }
            if(chars[i] == '('){
                status++;
            }
        }

        return status == 0;
    }


    public static int getMaxLength(String str){

        if(str.length() == 0 || str == null){
            return -1;
        }

        char[] chars = str.toCharArray();

        int[] dp = new int[chars.length];  //i位置代表必须以chars[i]结尾的字符能够形成的最长有效括号字符串的长度
        //dp[0] = 0;   //一个字符肯定无法形成有效括号

        int res = 0;
        for(int i = 1; i < chars.length; i++){
            if(chars[i] == ')'){  //不是右括号，肯定没办法形成有效括号字符串
                if(chars[i-dp[i-1]-1] == '('){  //dp[i-1],以前一个字符结尾的字符串的最长有效括号字符串长度，如果 chars[i-dp[i-1]-1] == '(',说明长度起码是dp[i-1] + 2,例:(()())的最后一个字符,倒数第二个字符的结果是4,
                    if(i-dp[i-1]-2 >= 0){
                        dp[i] = dp[i-1] + 2 + dp[i-dp[i-1]-2]; //还要考虑一种情况 ()(()),最后一个字符,倒数第二个字符的结果是2,但是最后一个字符的结果是6,所以还要加上 i-dp[i-1]-1-1 的结果,
                    }else{
                        dp[i] = dp[i-1] + 2; //
                    }
                }
            }
            res =Math.max(res,dp[i]);
        }

        return res;
    }

    public static void main(String[] args) {

        String str = "()(())())";
        System.out.println(getMaxLength(str));
    }
}
