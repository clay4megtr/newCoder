package org.clay.basic_class_02_Re;

public class JumpTaijie {

    /**
     * 一次跳一阶 / 一次跳两阶  调到n，总共几种跳法
     * @return
     */
    public static int process(int n){
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }

        return process(n-1) + process(n-2);
    }


}
