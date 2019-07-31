package org.clay.advanced_class_04;

import java.util.HashMap;
import java.util.Map;

public class Code_05_LongestSumSubArrayLength {

    public int maxLength(int[] arr, int aim) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1); // important
        int len = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - aim)) {
                len = Math.max(i - map.get(sum - aim), len); // i - map.get(sum - aim) 就表示以i位置为结尾的最长数组的长度
            }
            if (!map.containsKey(sum)) {  //加入累加和
                map.put(sum, i);
            }
        }
        return len;
    }
}
