package com.jinshengcong.tank;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * description
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 */
public class T {
    public static void main(String[] args) throws Exception {
        TankFrame tf = new TankFrame();
        // 初始化敌方坦克
        for (int i = 0; i < 5; i++) {
            tf.enemyTanksList.add(new Tank(50 + i * 100, 200, Dir.DOWN, tf));
        }
        while (true) {
            Thread.sleep(50);
            tf.repaint();
        }
    }
}
