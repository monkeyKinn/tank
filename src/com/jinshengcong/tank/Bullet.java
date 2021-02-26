package com.jinshengcong.tank;

import java.awt.*;

/**
 * description
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 */
public class Bullet {
    // 速度
    private static final int SPEED = 10;
    // 大小
    private static final int WIDTH = 5, HEIGHT = 5;
    // 坐标
    private int x, y;
    // 方向
    private Dir dir;
    // 活着的状态
    private boolean live = true;
    private TankFrame tf = null;

    public Bullet(int x, int y, Dir dir, TankFrame tf) {
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
        // 再画子弹时候判断子弹存活情况
        if (!live) {
            // 消除子弹
            tf.bulletList.remove(this);
        }
        // 画一个子弹
        switch (dir) {
            case UP:
                g.drawImage(ResourcesManger.bulletU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourcesManger.bulletD, x, y, null);
                break;
            case LEFT:
                g.drawImage(ResourcesManger.bulletL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourcesManger.bulletR, x, y, null);
                break;
            default:
                break;
        }
        move();
    }

    private void move() {
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
        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) {
            // 子弹消失
            live = false;
        }
    }
}
