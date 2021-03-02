package com.jinshengcong.tank.abstractfactory;

import com.jinshengcong.tank.*;

import java.awt.*;

/**
 * 子弹
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 */
public class RectBullet extends BaseBullet {
    // 速度
    private static final int SPEED = 20;
    // 大小
    public static final int WIDTH = ResourcesManger.bulletL.getWidth();
    public static final int HEIGHT = ResourcesManger.bulletL.getHeight();
    // 坐标
    private int x, y;
    // 方向
    private Dir dir;
    // 活着的状态
    private boolean live = true;
    private TankFrame tf = null;

    private Group group = Group.BAD;
    Rectangle rect = new Rectangle();

    public RectBullet(int x, int y, Dir dir, TankFrame tf, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
        this.group = group;

        rect.x = x;
        rect.y = y;
        rect.width = WIDTH;
        rect.height = HEIGHT;
        // new出来子弹后把自己加到bulletlist里面去
        tf.bulletList.add(this);
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    @Override
    public void collideWith(BaseTank tank) {

    }

    public void paint(Graphics g) {
        // 再画子弹时候判断子弹存活情况
        if (!live) {
            // 消除子弹
            tf.bulletList.remove(this);
        }
        // 画一个子弹
        Color color = g.getColor();
        g.setColor(Color.RED);
        g.fillRect(x,y, 20, 20);
        g.setColor(color);
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
        // 更新rect 这样矩形就跟着子弹在移动
        rect.x = this.x;
        rect.y = this.y;

        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) {
            // 子弹消失
            live = false;
        }
    }

    /**
     * 撞击
     *
     * @param tank
     * @return void
     * @author 金聖聰
     * @email jinshengcong@163.com
     * @version v1.0
     * @date 2021/02/27 0:09
     */
    public void collideWith(Tank tank) {
        // 队友伤害忽略
        if (this.group == tank.getGroup()) return;

        // 用一个rec来记录子弹的位置
        // 子弹本身的矩形与坦克的矩形相交
        if (rect.intersects(tank.rect)) {//相交
            tank.die();
            this.die();
            int eX = tank.getX() + Tank.WIDTH / 2 - Explode.WIDTH / 2;
            int eY = tank.getY() + Tank.HEIGHT / 2 - Explode.HEIGHT / 2;

            // tf.explodeList.add(new Explode(eX, eY, tf));
            // 用工厂
            tf.explodeList.add(tf.gameFactory.createExploded(eX, eY, tf));
        }
    }

    private void die() {
        this.live = false;
    }
}
