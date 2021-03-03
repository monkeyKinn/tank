package com.jinshengcong.tank.chainofresponsibility.impl;

import com.jinshengcong.tank.*;
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
            // 队友伤害忽略
            if (bullet.getGroup() == tank.getGroup()) return true;

            if (bullet.rect.intersects(tank.rect)) {//相交
                tank.die();
                bullet.die();
                int eX = tank.getX() + Tank.WIDTH / 2 - Explode.WIDTH / 2;
                int eY = tank.getY() + Tank.HEIGHT / 2 - Explode.HEIGHT / 2;
                // 添加一个爆炸
                GameModel.getInstance().add(new Explode(eX, eY));
                return false;
            }
        } else if (gameObject1 instanceof Tank && gameObject2 instanceof Bullet) {
           return collideWith(gameObject2, gameObject1);
        }
        return true;
    }
}
