package org.clay.Book_Re_Other;

/**
 * 给定 Random1To5，除此之外，不能使用任何的随机机制，只用 Random1To5 实现 Random1To7
 * <p>
 * 主要的就是 "插空" 的过程和 "筛选" 的过程
 */
public class Random1To7 {

    public int rand1To5() {
        return (int) (Math.random() * 5) + 1;
    }

    public int rand1To7() {
        int num = 0;
        do {
            num = (rand1To5()-1) + (rand1To5()-1) * 5;  //插空的过程，随机产生 0~24
        } while (num > 20); //筛的过程， 只要 0~20

        return 1 + num % 7;
    }

    /**
     * 补充题目：给定一个以p概率产生0，以(1-p)概率产生1的随机函数
     */
    public int rand01p(){
        //可任意改变p
        double p = 0.83;
        return Math.random() < p ? 0 : 1;
    }

    //生成等概率随机产生[0,1]的函数，
    //利用的性质，虽然rand01p()以p概率产生0，以p-1概率产生1，但是rand01p()产生[0,1]和[1,0]的概率却都是p*(1-p)，可以利用这个性质生成等概率随机产生0和1的函数
    public int rand01(){

        int i1 = rand01p();
        int i2 = rand01p();

        if(i1 == 1 && i2 == 0){
            return 0;
        }else if(i1 == 0 && i2 == 1){
            return 1;
        }else{
            return rand01();
        }
    }

    //等概率随机产生 0~3
    public int rand0To3(){
        return rand01() * 2 + rand01();
    }

    //等概率随机产生 1~6
    public int rand1To6(){
        int num = 0;
        do {
            num = rand0To3() * 4 + rand0To3();   //插空，等概率随机产生 0~15
        }while (num > 11); //筛，等概率随机产生 0~11

        return num % 6 + 1;
    }

    /**
     * 进阶题目：给定一个等概率随机产生 1~M 的随机函数 random1ToM，
     * 给定两个输入参数，分别为m和n，请用rand1~M(m)实现等概率随机产生 1~n 的随机函数 rand1ToN
     */

}