package com.jinshengcong.tank;

import java.awt.*;

/**
 * description
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 */
public class Tank {
    private int x, y;
    // 初始方向
    private Dir dir = Dir.RIGHT;
    // 速度
    private final static int SPEED = 5;
    // 停止
    private boolean moving = false;
    // tankFrame对象
    private TankFrame tf = null;

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Tank(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public void paint(Graphics g) {
        switch (dir) {
            case UP:
                g.drawImage(ResourcesManger.tankU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourcesManger.tankD, x, y, null);
                break;
            case LEFT:
                g.drawImage(ResourcesManger.tankL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourcesManger.tankR, x, y, null);
                break;
            default:
                break;
        }
        move();
    }

    private void move() {
        // 没有移动
        if (!moving) return;

        switch (dir) {
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            default:
                break;
        }
    }

    // 开火
    public void fire() {
        tf.bulletList.add(new Bullet(this.x, this.y, this.dir, this.tf));
    }
}
