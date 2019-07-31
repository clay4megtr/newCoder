package org.clay.advanced_class_04;

import java.util.HashMap;
import java.util.Map;

/**
 * 情况1：从 0 到 i 存在最优划分，i 所在的子数组不是异或和为 0 的部分，即不在最优划分里面，
 *  那么 0 到 i 部分能划分多少个异或和为0的子数组 和 0 到 i- 1 能划分多少个异或和为 0 的子数组的结果是一样的，
 *  dp[i] = dp[i - 1]
 *
 *  情况2：从 0 到 i 存在最优划分，i 所在的子数组是异或和为 0 的部分，即是最优划分的中异或和为0的部分，
 *  设 k 是 i 左边离它最近的异或和为0的位置，则问题变成，假设从 0 到 i 异或和为 sum，
 *  那么只需要找到从 0 到 i - 1 异或和为 sum 的位置的下一个位置就是 k 位置。
 *  dp[i] = dp[k - 1] + 1
 */
public class Code_06_Most_EOR {

    public static int mostEOR(int[] arrays){
        if(arrays == null || arrays.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int xor = 0;
        int res = 0;
        int[] dp = new int[arrays.length];
        for(int i = 0; i < arrays.length; i++){
            xor ^= arrays[i];
            if(map.containsKey(xor)){
                int pre = map.get(xor);
                dp[i] = pre == -1 ? 1 : (dp[pre] + 1);
            }
            if(i > 0){
                dp[i] = Math.max(dp[i], dp[i - 1]);
            }
            res = Math.max(dp[i], res);
            map.put(xor, i);
        }
        return res;
    }
    // for test
    public static int comparator(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[] eors = new int[arr.length];
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
            eors[i] = eor;
        }
        int[] mosts = new int[arr.length];
        mosts[0] = arr[0] == 0 ? 1 : 0;
        for (int i = 1; i < arr.length; i++) {
            mosts[i] = eors[i] == 0 ? 1 : 0;
            for (int j = 0; j < i; j++) {
                if ((eors[i] ^ eors[j]) == 0) {
                    mosts[i] = Math.max(mosts[i], mosts[j] + 1);
                }
            }
            mosts[i] = Math.max(mosts[i], mosts[i - 1]);
        }
        return mosts[mosts.length - 1];
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random());
        }
        return arr;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 300;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            int res = mostEOR(arr);
            int comp = comparator(arr);
            if (res != comp) {
                succeed = false;
                printArray(arr);
                System.out.println(res);
                System.out.println(comp);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}
