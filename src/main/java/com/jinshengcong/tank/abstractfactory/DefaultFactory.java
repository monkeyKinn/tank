package com.jinshengcong.tank.abstractfactory;

import com.jinshengcong.tank.*;

/**
 * 具体工厂 默认工厂
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 */
public class DefaultFactory extends GameFactory{

    @Override
    public BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tankFrame) {
        return new Tank(x, y, dir, group, tankFrame);
    }

    @Override
    public BaseExploded createExploded(int x, int y, TankFrame tankFrame) {
        return new Explode(x, y, tankFrame);
    }

    @Override
    public BaseBullet createBullet(int x, int y, Dir dir, TankFrame tf, Group group) {
        return new Bullet(x, y, dir, tf, group);
    }
}
