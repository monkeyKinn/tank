package com.jinshengcong.tank.strategy.impl;

import com.jinshengcong.tank.Audio;
import com.jinshengcong.tank.Bullet;
import com.jinshengcong.tank.Group;
import com.jinshengcong.tank.Tank;
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
        new Bullet(bX, bY, t.getDir(), t.gm, t.getGroup());
        if (t.getGroup() == Group.Good){
            new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
        }
    }
}
