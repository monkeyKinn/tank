package com.jinshengcong.tank.chainofresponsibility;

import com.jinshengcong.tank.GameObject;

/**
 * 碰撞器
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 */
public interface Collider{
    /**
     * 两个物体相撞
     * @param gameObject1 第一个game对象
     * @param gameObject2 第二个game对象
     * @return void 空
     * @author 金聖聰
     * @email jinshengcong@163.com
     * @version v1.0
     * @date 2021/03/03 17:04
     */
    boolean collideWith(GameObject gameObject1, GameObject gameObject2);
}
