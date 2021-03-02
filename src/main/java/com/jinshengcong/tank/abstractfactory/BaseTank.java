package com.jinshengcong.tank.abstractfactory;

import com.jinshengcong.tank.Dir;
import com.jinshengcong.tank.Group;
import com.jinshengcong.tank.TankFrame;

import java.awt.*;

/**
 * description
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 */
public abstract class BaseTank {
    public Group group = Group.BAD;
    public Rectangle rect = new Rectangle();

    public abstract void paint(Graphics g);

    public Group getGroup() {
        return this.group;
    }
    public abstract void die();

    public abstract int getX();
    public abstract int getY();

}

