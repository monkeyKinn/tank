package com.jinshengcong.tank.abstractfactory;


import com.jinshengcong.tank.Dir;
import com.jinshengcong.tank.Group;
import com.jinshengcong.tank.TankFrame;

/**
 * 抽象工厂
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 */
public abstract class GameFactory {
    //创建坦克
    public abstract BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tankFrame);
    // 创建爆炸
    public abstract BaseExploded createExploded(int x, int y, TankFrame tankFrame);
    // 创建子弹
    public abstract BaseBullet createBullet(int x, int y, Dir dir, TankFrame tf, Group group);
}
