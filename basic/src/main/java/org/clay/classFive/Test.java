package org.clay.classFive;

/**
 * 布隆过滤器测试
 */
public class Test {

    public static void main(String[] args) {

        int[] arr = new int[1000];  //32000个bit位。

        int index = 30000;          //把第30000个bit位描黑

        int intIndex = index / 32;  //位于第932个桶（位置）上。就是int 数组第932个index上

        int bitIndex = index % 32;  //第932个int位置上的第16个bit位上。一个int有32个bit位

        //第932个桶中的第16个bit位置应该被描黑

        // 1 左移 bitIndex 就表示32个bit位置， 只有 第bitIndex 位置为1，其他31位都是0，

        arr[intIndex] = (arr[intIndex] | (1 << bitIndex));//(1 << bitIndex)表示第16个位置上是1，其他都是0，
        //(arr[intIndex]  或  (第16个位置上是1 其他都是0的二进制)  则原bit位第16个bit位原位置就变黑了。
    }
}
