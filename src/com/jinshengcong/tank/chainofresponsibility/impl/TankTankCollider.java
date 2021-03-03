package com.jinshengcong.tank.chainofresponsibility.impl;

import com.jinshengcong.tank.Bullet;
import com.jinshengcong.tank.GameObject;
import com.jinshengcong.tank.Tank;
import com.jinshengcong.tank.chainofresponsibility.Collider;

import java.awt.*;

/**
 * description
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 */
public class TankTankCollider implements Collider {
    @Override
    public boolean collideWith(GameObject gameObject1, GameObject gameObject2) {
        if (gameObject1 instanceof Tank && gameObject2 instanceof Tank) {
            Tank tank1 = (Tank) gameObject1;
            Tank tank2 = (Tank) gameObject2;
            if (tank1.getRect().intersects(tank2.getRect())) {
                tank1.back();
                tank2.back();
            }
        }
        return true;
    }
}
