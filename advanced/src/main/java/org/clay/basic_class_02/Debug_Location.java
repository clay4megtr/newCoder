package org.clay.basic_class_02;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Debug_Location {

    public static void main(String[] args) throws Exception{

        int x = 100;
        int y = 100;

        doubleClick(x,y);
    }

    public static void doubleClick(int x, int y) throws Exception{

        Robot myRobot = new Robot();
        myRobot.mouseMove(x, y);
        myRobot.mousePress(KeyEvent.BUTTON1_DOWN_MASK);		// 模拟按下鼠标左键
        myRobot.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);	// 模拟释放鼠标左键
        myRobot.mousePress(KeyEvent.BUTTON1_DOWN_MASK);		// 模拟按下鼠标左键
        myRobot.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);	// 模拟释放鼠标左键
    }
}
