package com.jinshengcong.tank.decorator;

import com.jinshengcong.tank.GameObject;

import java.awt.*;

/**
 * 游戏对象的装饰者
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 */
public abstract class GODecorator extends GameObject {
    // 聚和一个
    GameObject gameObject;

    public GODecorator(GameObject gameObject) {
        this.x=gameObject.x;
        this.y = gameObject.y;
        this.gameObject = gameObject;
    }

    @Override
    public abstract void paint(Graphics g);
}
