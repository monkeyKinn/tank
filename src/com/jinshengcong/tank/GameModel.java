package com.jinshengcong.tank;

import com.jinshengcong.tank.chainofresponsibility.Collider;
import com.jinshengcong.tank.chainofresponsibility.ColliderChain;
import com.jinshengcong.tank.chainofresponsibility.impl.BulletTankCollider;
import com.jinshengcong.tank.chainofresponsibility.impl.TankTankCollider;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 游戏的模型    实体类大管家 facade (门面)模式负责与frame 打交道 同时负责内部事务
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 */
public class GameModel {
    private static final GameModel INSTANCE = new GameModel();
    Tank myTank = new Tank(200, 500, Dir.DOWN, Group.Good);
    ColliderChain chain = new ColliderChain();

    private List<GameObject> gameObjects = new ArrayList<>();

    public void add(GameObject gameObject) {
        this.gameObjects.add(gameObject);
    }

    public void remove(GameObject gameObject) {
        this.gameObjects.remove(gameObject);
    }
    public static GameModel getInstance(){
        return INSTANCE;
    }
    private GameModel() {
        int initEnemyTankCount = Integer.parseInt((String) PropertyMgr.getValue("initEnemyTankCount"));
        // 初始化敌方坦克
        for (int i = 0; i < initEnemyTankCount; i++) {
            this.add(new Tank(50 + i * 100, 200, Dir.DOWN, Group.BAD));
        }

        // 初始化墙
        this.add(new Wall(150, 150, 200, 50));
        this.add(new Wall(550, 150, 200, 50));
        this.add(new Wall(300, 300, 50, 250));
        this.add(new Wall(550, 300, 50, 550));
    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.CYAN);
        // g.drawString("子弹数量: " + bulletList.size(), 10, 60);
        // g.drawString("敌方坦克数量: " + enemyTanksList.size(), 10, 80);
        // g.drawString("爆炸数量: " + explodeList.size(), 10, 100);
        g.setColor(c);

        // 画我的坦克
        myTank.paint(g);
        for (int i = 0; i < gameObjects.size(); i++) {
            gameObjects.get(i).paint(g);
        }

        // 碰撞
        for (int i = 0; i < gameObjects.size(); i++) {
            for (int j = i + 1; j < gameObjects.size(); j++) {
                GameObject gameObject1 = gameObjects.get(i);
                GameObject gameObject2 = gameObjects.get(j);
                chain.collideWith(gameObject1, gameObject2);
            }
        }
        // for (int i = 0; i < bulletList.size(); i++) {
        //     for (int j = 0; j < enemyTanksList.size(); j++) {
        //         bulletList.get(i).collideWith(enemyTanksList.get(j));
        //     }
        // }
    }

    public Tank getMyTank() {
        return this.myTank;
    }
}
