package org.clay.basic_class_02_Re;

import java.util.Arrays;
import java.util.LinkedList;

public class WindowMaxNumber {


    public static int[] getMaxNumber(int[] arr, int window_length) {

        int[] res = new int[arr.length - window_length + 1];
        int pos = 0;

        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {

            while (!queue.isEmpty()) {
                if (arr[i] > arr[queue.peekLast()]) {
                    queue.pollLast();
                } else {
                    break;
                }
            }
            queue.addLast(i);

            if (i == window_length - 1) {
                res[pos++] = arr[queue.peekFirst()];
            } else if (i > window_length - 1) {
                if (queue.peekFirst() == i - window_length) {
                    queue.pollFirst();
                }
                res[pos++] = arr[queue.peekFirst()];
            }
        }

        return res;
    }

    public static void printArr(int[] arr) {

        Arrays.stream(arr).forEach(System.out::println);
    }

    public static void main(String[] args) {

        int[] arr = new int[]{4, 3, 5, 4, 3, 3, 6, 7};
        printArr(getMaxNumber(arr, 3));
    }
}
