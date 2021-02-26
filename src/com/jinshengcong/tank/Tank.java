package com.jinshengcong.tank;

import java.awt.*;
import java.util.Random;

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
    private final static int SPEED = 1;
    // 停止
    private boolean moving = true;
    // tankFrame对象
    private TankFrame tf = null;
    //生死状态
    private boolean live = true;

    private Group group = Group.BAD;

    private Random random = new Random();

    public static final int WIDTH = ResourcesManger.tankD.getWidth();
    public static final int HEIGHT = ResourcesManger.tankD.getHeight();

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Tank(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
        this.group = group;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public void paint(Graphics g) {
        if (!live) {
            tf.enemyTanksList.remove(this);
        }
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
        if (random.nextInt(10) > 5) {
            this.fire();
        }
    }

    // 开火
    public void fire() {
        int bX = this.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = this.y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        tf.bulletList.add(new Bullet(bX, bY, this.dir, this.tf, this.group));
    }

    public void die() {
        this.live = false;
    }
}
