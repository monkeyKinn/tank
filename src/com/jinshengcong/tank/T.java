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

        // 播放背景音乐
        // new Thread(()->new Audio("audio/war1.wav").loop()).start();
        while (true) {
            Thread.sleep(50);
            tf.repaint();
        }
    }
}
