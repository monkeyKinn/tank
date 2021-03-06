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
    Rectangle rect = new Rectangle();;
    private int x, y;
    // 初始方向
    private Dir dir = Dir.RIGHT;
    // 速度
    private final static int SPEED = 10;
    // 停止
    private boolean moving = true;
    // tankFrame对象
    private TankFrame tf = null;
    //生死状态
    private boolean live = true;

    private Group group = Group.BAD;

    private Random random = new Random();

    public static final int WIDTH = ResourcesManger.goodTankU.getWidth();
    public static final int HEIGHT = ResourcesManger.goodTankU.getHeight();

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

        this.rect.x = x;
        this.rect.y = y;
        this.rect.width = WIDTH;
        this.rect.height = HEIGHT;
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
                g.drawImage(this.group == Group.Good ? ResourcesManger.goodTankU : ResourcesManger.badTankU, x, y,
                        null);
                break;
            case DOWN:
                g.drawImage(this.group == Group.Good ? ResourcesManger.goodTankD : ResourcesManger.badTankD, x, y,
                        null);
                break;
            case LEFT:
                g.drawImage(this.group == Group.Good ? ResourcesManger.goodTankL : ResourcesManger.badTankL, x, y,
                        null);
                break;
            case RIGHT:
                g.drawImage(this.group == Group.Good ? ResourcesManger.goodTankR : ResourcesManger.badTankR, x, y,
                        null);
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


        if (this.group == Group.BAD && random.nextInt(100) > 95) {
            this.fire();
        }
        if (this.group == Group.BAD && random.nextInt(100) > 95) {
            randomDir();
        }
        // 做边界检测
        boundsCheck();

        // 更新rect 这样矩形就跟着子弹在移动
        rect.x = this.x;
        rect.y = this.y;
    }

    /**
     * 边界检测
     *
     * @return void
     * @author 金聖聰
     * @email jinshengcong@163.com
     * @version v1.0
     * @date 2021/02/27 15:33
     */
    private void boundsCheck() {
        if (this.x < 2) {
            x = 2;
        }
        if (this.y < 102) {
            y = 102;
        }
        if (this.x > TankFrame.GAME_WIDTH - Tank.WIDTH - 2) {
            x = TankFrame.GAME_WIDTH - Tank.WIDTH - 2;
        }
        if (this.y > TankFrame.GAME_HEIGHT - Tank.HEIGHT - 2) {
            y = TankFrame.GAME_HEIGHT - Tank.HEIGHT - 2;
        }
    }

    /**
     * 随机方向
     *
     * @return void
     * @author 金聖聰
     * @email jinshengcong@163.com
     * @version v1.0
     * @date 2021/02/27 2:12
     */
    private void randomDir() {
        this.dir = Dir.values()[random.nextInt(4)];
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
