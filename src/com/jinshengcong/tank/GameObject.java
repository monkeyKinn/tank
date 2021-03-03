package com.jinshengcong.tank;

import java.awt.*;

/**
 * 游戏中所有物体的父类
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 */
public abstract class GameObject {
    public int x,y;

    public abstract void paint(Graphics g);
    public abstract int getWidth();
    public abstract int getHeight();

}
