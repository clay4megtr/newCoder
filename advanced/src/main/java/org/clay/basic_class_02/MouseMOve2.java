package org.clay.basic_class_02;

import java.awt.*;
import java.awt.event.KeyEvent;

public class MouseMOve2 {

    public static void main(String[] args) {

        int x = 100;
        int y = 100;

        int x1 = 600;
        int y1 = 600;

        //关闭播放器需要双击的位置
        int shutdown_player_x = 100;
        int shutdown_player_y = 100;

        //打开新的播放文件需要双击的位置
        int new_player_x = 100;
        int new_player_y = 200;

        //阈值，超过这个间隔触发关闭播放器的行为,在(shutdown_player_x,shutdown_player_y)处触发双击
        long threshold = 5;   //单位 秒

        long startTime=System.currentTimeMillis();   //获取开始时间

        try {
            boolean flag = true;  //开关，标记 触发关闭播放器的行为 只能触发一次

            Robot myRobot = new Robot();

            while (true){
                //获取现在的时间戳
                long nowTime=System.currentTimeMillis(); //获取now时间

                long seconds = (nowTime - startTime) / 1000; //过了多少秒了
                if(flag && seconds >= threshold){
                    flag = false;

                    //触发关闭播放器的行为,只触发一次；
                    System.out.println("shutdown player");
                    doubleClick(shutdown_player_x, shutdown_player_y,myRobot);

                    //新视频文件的位置,需要双击打开；
                    System.out.println("open new player");
                    doubleClick(new_player_x, new_player_y,myRobot);
                }


                // 移动鼠标到坐标（x,y)处，并点击左键
                myRobot.mouseMove(x, y);				// 移动鼠标到坐标（x,y）处
                myRobot.mousePress(KeyEvent.BUTTON1_DOWN_MASK);		// 模拟按下鼠标左键
                myRobot.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);	// 模拟释放鼠标左键

                Thread.sleep(2500);

                myRobot.mouseMove(x1, y1);				// 移动鼠标到坐标（x,y）处
                myRobot.mousePress(KeyEvent.BUTTON1_DOWN_MASK);		// 模拟按下鼠标左键
                myRobot.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);	// 模拟释放鼠标左键

                Thread.sleep(2500);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public static void doubleClick(int x,int y,Robot myRobot){
        myRobot.mouseMove(x, y);
        System.out.println("double click");
        myRobot.mousePress(KeyEvent.BUTTON1_DOWN_MASK);		// 模拟按下鼠标左键
        myRobot.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);	// 模拟释放鼠标左键
        myRobot.mousePress(KeyEvent.BUTTON1_DOWN_MASK);		// 模拟按下鼠标左键
        myRobot.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);	// 模拟释放鼠标左键
    }
}
