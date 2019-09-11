package org.clay.test3;

public class NextArray {

    public static int[] getNextArray1(char[] ms) {
        if (ms.length == 1) {
            return new int[] { -1 };
        }
        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        int pos = 2; //来到的位置
        int cn = 0;   // 跳到的位置
        while (pos < next.length) {  // pos不断增加，每一个位置都要求出来，
            if (ms[pos - 1] == ms[cn]) {  //如果当前跳到的位置和前一个字符是一致的，i位置的最长后缀长度就是i-1位置最长后缀长度+1
                next[pos++] = ++cn;  //cn其实就是第一个最长后缀的下一个字符，所以跳到cn就表示第一个最长后缀的长度就是cn，那么pos位置的最长后缀长度就是:cn+1
            } else if (cn > 0) {  //不相等，就再往前跳
                cn = next[cn];  //next[cn]就表示cn位置的最长后缀长度，也就是跳到第一个最长后缀的下一个字符，
            } else {
                next[pos++] = 0; //cn <= 0，说明跳到头了；pos位置的最长后缀长度就是0；
            }
        }
        return next;
    }

    //注意求某个位置的前缀和后缀的时候，是不包含当前字符的，这个点总会弄错；第一个值-1,第二个值0,从第三个值开始算
    public static int[] getNextArray(char[] arr){

        int[] res = new int[arr.length];
        res[0] = -1;
        res[1] = 0;

        int pos = 2;

        while(pos < res.length){

            int nIndex = res[pos-1];
            while(nIndex >= 0){
                if(arr[nIndex] == arr[pos-1]){
                    res[pos] = nIndex + 1;
                    break;
                }else{
                    nIndex = res[nIndex];
                }
            }
            pos += 1;
        }

        return res;
    }


    public static void main(String[] args) {

        String str = "ababcababtk";
        int[] res = getNextArray(str.toCharArray());
        System.out.println(res[9]);
    }
}