package com.jinshengcong.dp.factory.abstractfactory;

/**
 * 抽象工厂生产抽象产品
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 */
public abstract class AbstractFactory {
    //产生三个不同的产品 食物 武器 交通工具
    abstract AbstractFood createFood();
    abstract AbstractWeapon createWeapon();
    abstract AbstractVehicle createVehicle();
}
