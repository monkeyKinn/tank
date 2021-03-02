package com.jinshengcong.tank;

import com.sun.deploy.util.StringUtils;

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
        int initEnemyTankCount = Integer.parseInt((String) PropertyMgr.getValue("initEnemyTankCount"));
        // 初始化敌方坦克
        for (int i = 0; i < initEnemyTankCount; i++) {
            tf.enemyTanksList.add(tf.gameFactory.createTank(50 + i * 100, 200, Dir.DOWN, Group.BAD, tf));
        }
        // 播放背景音乐
        // new Thread(()->new Audio("audio/war1.wav").loop()).start();
        while (true) {
            Thread.sleep(25);
            tf.repaint();
        }
    }
}
