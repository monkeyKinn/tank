package com.jinshengcong.tank;

/**
 * description
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 */
public class FourDirFireStrategy implements FireStrategy {
    @Override
    public void fire(Tank t) {
        int bX = t.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = t.getY() + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        //得到枚举的所有值
        Dir[] dirs = Dir.values();
        for (Dir dir : dirs) {
            new Bullet(bX, bY, dir, t.getTf(), t.getGroup());
        }

        if (t.getGroup() == Group.Good) {
            new Thread(() -> new Audio("audio/tank_fire.wav").play()).start();
        }
    }
}
