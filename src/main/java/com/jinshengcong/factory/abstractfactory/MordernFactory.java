package com.jinshengcong.factory.abstractfactory;

/**
 * description
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 */
public class MordernFactory extends AbstractFactory{
    @Override
    AbstractFood createFood() {
        return new Bread();
    }

    @Override
    AbstractWeapon createWeapon() {
        return new AK47();
    }

    @Override
    AbstractVehicle createVehicle() {
        return new Car();
    }
}
