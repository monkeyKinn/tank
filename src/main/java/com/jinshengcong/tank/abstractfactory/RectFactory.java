package com.jinshengcong.tank.abstractfactory;

import com.jinshengcong.tank.Dir;
import com.jinshengcong.tank.Group;
import com.jinshengcong.tank.TankFrame;

import java.awt.*;

/**
 * 产生方的爆炸的具体工厂
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 */
public class RectFactory extends GameFactory {

    @Override
    public BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tankFrame) {
        return new RectTank(x, y, dir, group, tankFrame);
    }

    @Override
    public BaseExploded createExploded(int x, int y, TankFrame tankFrame) {
        return new RectExplode(x, y, tankFrame);
    }

    @Override
    public BaseBullet createBullet(int x, int y, Dir dir, TankFrame tf, Group group) {
        return new RectBullet(x, y, dir, tf, group);
    }
}
