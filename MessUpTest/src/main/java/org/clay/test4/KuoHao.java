package org.clay.test4;

/**
 * 最长有效括号
 */
public class KuoHao {

    /**
     * 求以每个字符结尾的子串的最长有效括号
     */
    public static int getMaxLength(char[] str){

        int[] dp = new int[str.length];

        int max = Integer.MIN_VALUE;

        for(int i = 1; i < str.length; i++){
            if(str[i] == ')'){   // 只有结尾是 ) 才可能是有效的括号

                if(i - dp[i-1] - 1 >= 0){
                    if(str[i - dp[i-1] - 1] == '('){
                        if(i - dp[i-1] - 2 >= 0){
                            dp[i] = dp[i-1] + 2 + dp[i - dp[i-1] - 2];
                        }else {
                            dp[i] = dp[i-1] + 2;
                        }
                    }
                }
            }
            max = Math.max(max,dp[i]);
        }

        return max;
    }

    public static void main(String[] args) {

        System.out.println(getMaxLength("()(())())".toCharArray()));
    }
}
