package com.jinshengcong.tank;

import com.jinshengcong.tank.abstractfactory.BaseTank;

/**
 * description
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 */
public class DefaultFireStrategy implements FireStrategy{

    @Override
    public void fire(Tank t) {
        int bX = t.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = t.getY() + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        new Bullet(bX, bY, t.getDir(), t.getTf(), t.getGroup());
        if (t.getGroup() == Group.Good){
            new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
        }
    }
}
