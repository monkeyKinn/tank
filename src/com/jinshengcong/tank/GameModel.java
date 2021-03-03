package com.jinshengcong.tank;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 实体类大管家
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 */
public class GameModel {

    java.util.List<Bullet> bulletList = new ArrayList<>();
    java.util.List<Tank> enemyTanksList = new ArrayList<>();
    List<Explode> explodeList = new ArrayList<>();

    Tank myTank = new Tank(200, 500, Dir.DOWN, Group.Good, this);


    public GameModel() {
        int initEnemyTankCount = Integer.parseInt((String) PropertyMgr.getValue("initEnemyTankCount"));
        // 初始化敌方坦克
        for (int i = 0; i < initEnemyTankCount; i++) {
            this.enemyTanksList.add(new Tank(50 + i * 100, 200, Dir.DOWN, Group.BAD, this));
        }

    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.CYAN);
        g.drawString("子弹数量: " + bulletList.size(), 10, 60);
        g.drawString("敌方坦克数量: " + enemyTanksList.size(), 10, 80);
        g.drawString("爆炸数量: " + explodeList.size(), 10, 100);
        g.setColor(c);

        // 画我的坦克
        myTank.paint(g);
        for (int i = 0; i < bulletList.size(); i++) {
            bulletList.get(i).paint(g);
        }
        // 画敌方坦克
        for (int i = 0; i < enemyTanksList.size(); i++) {
            enemyTanksList.get(i).paint(g);
        }
        // 画爆炸
        for (int i = 0; i < explodeList.size(); i++) {
            explodeList.get(i).paint(g);
        }
        // 碰撞
        for (int i = 0; i < bulletList.size(); i++) {
            for (int j = 0; j < enemyTanksList.size(); j++) {
                bulletList.get(i).collideWith(enemyTanksList.get(j));
            }
        }
    }

    public Tank getMyTank() {
        return this.myTank;
    }
}
