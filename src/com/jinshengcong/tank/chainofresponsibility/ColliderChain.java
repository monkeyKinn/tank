package com.jinshengcong.tank.chainofresponsibility;

import com.jinshengcong.tank.GameObject;
import com.jinshengcong.tank.chainofresponsibility.impl.BulletTankCollider;
import com.jinshengcong.tank.chainofresponsibility.impl.TankTankCollider;

import java.util.LinkedList;
import java.util.List;

/**
 * description
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 */
public class ColliderChain implements Collider {
    private List<Collider> colliderList = new LinkedList<>();

    public ColliderChain() {
        add(new BulletTankCollider());
        add(new TankTankCollider());
    }

    public void add(Collider collider) {
        colliderList.add(collider);
    }

    /**
     * 碰撞
     * @param gameObject1
     * @param gameObject2
     * @return void
     * @author 金聖聰
     * @email jinshengcong@163.com
     * @version v1.0
     * @date 2021/03/03 17:48
     */
    public boolean collideWith(GameObject gameObject1, GameObject gameObject2) {
        for (int i = 0; i < colliderList.size(); i++) {
            if (!colliderList.get(i).collideWith(gameObject1, gameObject2)){
                return false;
            }
        }
        return true;
    }

}
