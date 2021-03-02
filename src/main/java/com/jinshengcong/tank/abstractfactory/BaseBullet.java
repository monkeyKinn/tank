package com.jinshengcong.tank.abstractfactory;

import com.jinshengcong.tank.Tank;

import java.awt.*;

/**
 * description
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 */
public abstract class BaseBullet {
    public abstract void collideWith(BaseTank tank);

    public abstract void paint(Graphics g);


}
