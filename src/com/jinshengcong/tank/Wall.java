package com.jinshengcong.tank;

import java.awt.*;

/**
 * description
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 */
public class Wall extends GameObject{
    int w,h;
    public Rectangle rect;

    public Wall(int x,int y, int w, int h) {
        this.w = w;
        this.h = h;
        this.x = x;
        this.y = y;

        this.rect = new Rectangle(x, y, w, h);
    }

    @Override
    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.DARK_GRAY);
        g.fillRect(x, y, w, h);
        g.setColor(color);
    }
    @Override
    public int getWidth() {
        return w;
    }

    @Override
    public int getHeight() {
        return h;
    }
}
