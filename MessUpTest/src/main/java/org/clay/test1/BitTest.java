package org.clay.test1;

public class BitTest {

    public static void main(String[] args) {

        int[] arr = new int[1000]; // 32000 bitmap

        int index = 30000;  //fuck 30000 location black

        //find the index's location
        int int_index = index / 32 + 1;
        int bit_index = int_index % 32;

        arr[index] = (arr[index] | 1 << bit_index);
    }
}
