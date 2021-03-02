package com.jinshengcong.tank.abstractfactory;

import com.jinshengcong.tank.ResourcesManger;
import com.jinshengcong.tank.TankFrame;

import java.awt.*;

/**
 * 方的爆炸
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 */
public class RectExplode extends BaseExploded{
    // 大小
    public static final int WIDTH = ResourcesManger.explodes[0].getWidth();
    public static final int HEIGHT = ResourcesManger.explodes[0].getHeight();
    // 坐标
    private int x, y;
    // 活着的状态
    private TankFrame tf = null;
    // 爆炸图片的数组下标
    private int step = 0;

    public RectExplode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
        // new Audio("audio/explode.wav").play();
    }

    @Override
    public void paint(Graphics g) {
        // g.drawImage(ResourcesManger.explodes[step++], x, y, null);
        Color color = g.getColor();
        g.setColor(Color.red);
        g.fillRect(x, y, 10*step, 10*step);
        step++;
        if (step >= 5) {
            tf.explodeList.remove(this);
        }
        g.setColor(color);
    }
}
