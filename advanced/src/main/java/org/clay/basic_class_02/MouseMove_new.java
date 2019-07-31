package org.clay.basic_class_02;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class MouseMove_new {

    public static void main(String[] args) {

        //==================================================================
        //                          以下八个参数需要设置                       //
        //==================================================================

        //关闭播放器需要双击的位置
        int shutdown_player_x = 100;
        int shutdown_player_y = 100;

        //打开第二个播放文件需要双击的位置
        int second_player_x = 100;
        int second_player_y = 200;

        //打开第三个播放文件需要双击的位置
        int third_player_x = 100;
        int third_player_y = 200;

        //阈值，超过这个间隔触发关闭播放器的行为,在(shutdown_player_x,shutdown_player_y)处触发双击
        long first_threshold = 5;   //单位 秒   //第一个视频文件的长度
        long second_threshold = 10;   //单位 秒  //第二个视频文件的长度

        int x = 100;
        int y = 100;

        int x1 = 600;
        int y1 = 600;


        long startTime=System.currentTimeMillis();   //获取开始时间

        try {
            int flag = 0;  //开关，标记触发关闭播放器的行为 只能触发两次

            Robot myRobot = new Robot();

            while (true){
                //获取现在的时间戳
                long nowTime=System.currentTimeMillis(); //获取now时间

                long seconds = (nowTime - startTime) / 1000; //过了多少秒了

                if(flag == 0){
                    if(seconds >= first_threshold){  //第一个视频该关闭了
                        flag = flag + 1;

                        //触发关闭播放器的行为,
                        System.out.println("shutdown first player");
                        doubleClick(shutdown_player_x, shutdown_player_y,myRobot);

                        //打开第二个视频
                        System.out.println("open second player");
                        doubleClick(second_player_x, second_player_y,myRobot);

                        startTime=System.currentTimeMillis();   //开始时间要置为新时间，代表新的开始
                    }
                }

                long new_nowTime=System.currentTimeMillis(); //获取now时间
                long new_seconds = (new_nowTime - startTime) / 1000; //过了多少秒了
                if(flag == 1){
                    if(new_seconds >= second_threshold){  //第二个视频该关闭了
                        flag = flag + 1;
                        //触发关闭播放器的行为,
                        System.out.println("shutdown second player");
                        doubleClick(shutdown_player_x, shutdown_player_y,myRobot);

                        //打开第三个视频
                        System.out.println("open third player");
                        doubleClick(third_player_x, third_player_y,myRobot);
                    }
                }
                //第三个视频就不关闭了；


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
        myRobot.mousePress(KeyEvent.BUTTON1_DOWN_MASK);		// 模拟按下鼠标左键
        myRobot.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);	// 模拟释放鼠标左键
        myRobot.mousePress(KeyEvent.BUTTON1_DOWN_MASK);		// 模拟按下鼠标左键
        myRobot.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);	// 模拟释放鼠标左键
    }
}