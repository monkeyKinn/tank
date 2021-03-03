package com.jinshengcong.tank.decorator;

import com.jinshengcong.tank.GameObject;

import java.awt.*;

/**
 * description
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 */
public class RectDecorator extends GODecorator{


    public RectDecorator(GameObject gameObject) {
        super(gameObject);
    }

    @Override
    public void paint(Graphics g) {
        this.x=gameObject.x;
        this.y = gameObject.y;
        gameObject.paint(g);
        Color color = g.getColor();
        g.setColor(Color.WHITE);
        g.drawRect(gameObject.x,gameObject.y,getWidth(),getHeight());
        g.setColor(color);
    }

    @Override
    public int getWidth() {
        return super.gameObject.getWidth();
    }

    @Override
    public int getHeight() {
        return super.gameObject.getHeight();
    }

}
