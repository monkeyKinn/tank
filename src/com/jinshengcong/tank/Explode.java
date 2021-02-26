package com.jinshengcong.tank;

import java.awt.*;

/**
 * description
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 */
public class Explode {
    // 大小
    public static final int WIDTH = ResourcesManger.explodes[0].getWidth();
    public static final int HEIGHT = ResourcesManger.explodes[0].getHeight();
    // 坐标
    private int x, y;
    // 活着的状态
    private TankFrame tf = null;
    // 爆炸图片的数组下标
    private int step = 0;

    public Explode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
        new Audio("audio/explode.wav").play();
    }

    public void paint(Graphics g) {
        g.drawImage(ResourcesManger.explodes[step++], x, y, null);
        if (step >= ResourcesManger.explodes.length) {
            tf.explodeList.remove(this);
        }
    }
}
