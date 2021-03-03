package com.jinshengcong.tank.chainofresponsibility.impl;

import com.jinshengcong.tank.Bullet;
import com.jinshengcong.tank.GameObject;
import com.jinshengcong.tank.Tank;
import com.jinshengcong.tank.chainofresponsibility.Collider;

/**
 * description
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 */
public class BulletTankCollider implements Collider {
    @Override
    public boolean collideWith(GameObject gameObject1, GameObject gameObject2) {
        if (gameObject1 instanceof Bullet && gameObject2 instanceof Tank) {
            Bullet bullet = (Bullet) gameObject1;
            Tank tank = (Tank) gameObject2;
            if (bullet.collideWith(tank)) {
                return false;
            }
        } else if (gameObject1 instanceof Tank && gameObject2 instanceof Bullet) {
           return collideWith(gameObject2, gameObject1);
        }
        return true;
    }
}
