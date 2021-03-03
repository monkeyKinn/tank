package com.jinshengcong.tank.strategy.impl;

import com.jinshengcong.tank.*;
import com.jinshengcong.tank.decorator.RectDecorator;
import com.jinshengcong.tank.strategy.FireStrategy;

/**
 * description
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 */
public class DefaultFireStrategy implements FireStrategy {

    @Override
    public void fire(Tank t) {
        int bX = t.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = t.getY() + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        GameModel.getInstance().add(new RectDecorator(new Bullet(bX, bY, t.getDir(), t.getGroup())));
        if (t.getGroup() == Group.Good){
            new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
        }
    }
}
