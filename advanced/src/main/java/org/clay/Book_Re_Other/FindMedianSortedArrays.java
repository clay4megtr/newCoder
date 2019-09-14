package org.clay.Book_Re_Other;

/**
 * 返回两个有序数组的中位数
 */
public class FindMedianSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2){

        int n = nums1.length;
        int m = nums2.length;

        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;

        //将偶数和奇数的情况合并，如果是奇数，会求两次同样的k 。
        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
    }

    /**
     * 返回两个排序数组的第k小的数字
     * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-2/
     */
    private static double getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {

        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;

        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);

        //终止条件，其中一个数组已经空了；
        if (len1 == 0) return nums2[start2 + k - 1];

        //终止条件，找第一小的；
        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        //具体逻辑
        int i = start1 + Math.min(len1, k / 2) - 1; //nums1数组停止的位置；
        int j = start2 + Math.min(len2, k / 2) - 1; //nums2...

        //舍弃nums[k/2]小的内个数组 k/2之前的部分；
        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1)); //nums2从b+1开始继续找；
        }
        else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }
}