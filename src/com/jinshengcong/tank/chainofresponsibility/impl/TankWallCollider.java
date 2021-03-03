package com.jinshengcong.tank.chainofresponsibility.impl;

import com.jinshengcong.tank.Bullet;
import com.jinshengcong.tank.GameObject;
import com.jinshengcong.tank.Tank;
import com.jinshengcong.tank.Wall;
import com.jinshengcong.tank.chainofresponsibility.Collider;

/**
 * description
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 */
public class TankWallCollider implements Collider {
    @Override
    public boolean collideWith(GameObject gameObject1, GameObject gameObject2) {
        if (gameObject1 instanceof Tank && gameObject2 instanceof Wall) {
            Tank tank = (Tank) gameObject1;
            Wall wall = (Wall) gameObject2;

            if (tank.rect.intersects(wall.rect)){
                tank.back();
            }
        } else if (gameObject1 instanceof Wall && gameObject2 instanceof Tank) {
           return collideWith(gameObject2, gameObject1);
        }
        return true;
    }
}
