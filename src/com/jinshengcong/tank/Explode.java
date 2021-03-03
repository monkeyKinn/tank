package com.jinshengcong.tank;

import java.awt.*;

/**
 * 爆炸
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 */
public class Explode  extends GameObject{
    // 大小
    public static final int WIDTH = ResourcesManger.explodes[0].getWidth();
    public static final int HEIGHT = ResourcesManger.explodes[0].getHeight();
    // 爆炸图片的数组下标
    private int step = 0;

    public Explode(int x, int y) {
        this.x = x;
        this.y = y;
        // new Audio("audio/explode.wav").play();
    }

    public void paint(Graphics g) {
        g.drawImage(ResourcesManger.explodes[step++], x, y, null);
        if (step >= ResourcesManger.explodes.length) {
            GameModel.getInstance().remove(this);
        }
    }

    @Override
    public int getWidth() {
        return WIDTH;
    }

    @Override
    public int getHeight() {
        return HEIGHT;
    }
}
